package org.example.spring.service.serviceImpl.sqlToMongoMigrationService;

import org.example.spring.converter.MongoEntityConverter;
import org.example.spring.dao.mongoDaoImpl.EventMongoDaoImpl;
import org.example.spring.dao.mongoDaoImpl.TicketMongoDaoImpl;
import org.example.spring.dao.mongoDaoImpl.UserMongoDaoImpl;
import org.example.spring.dao.sqlDaoImpl.EventSqlDaoImpl;
import org.example.spring.dao.sqlDaoImpl.TicketSQLDaoImpl;
import org.example.spring.dao.sqlDaoImpl.UserSqlDaoImpl;
import org.example.spring.model.Entity.EventEntity;
import org.example.spring.model.Entity.TicketEntity;
import org.example.spring.model.Entity.UserEntity;
import org.example.spring.model.MongoEntity.EventMongoEntity;
import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.example.spring.model.MongoEntity.UserMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SqlToMongoMigrationService {
    private List<EventEntity> eventEntityList;
    private List<UserEntity> userEntityList;
    private List<TicketEntity> ticketEntityList;
    private EventSqlDaoImpl eventSqlDao;
    private UserSqlDaoImpl userSqlDao;
    private TicketSQLDaoImpl ticketSQLDao;
    private EventMongoDaoImpl eventMongoDao;
    private UserMongoDaoImpl userMongoDao;
    private TicketMongoDaoImpl ticketMongoDao;
    private MongoEntityConverter mongoEntityConverter;

    public SqlToMongoMigrationService() {
    }

    @Autowired
    public SqlToMongoMigrationService(EventSqlDaoImpl eventSqlDao, UserSqlDaoImpl userSqlDao,
                                      TicketSQLDaoImpl ticketSQLDao, EventMongoDaoImpl eventMongoDao,
                                      UserMongoDaoImpl userMongoDao, TicketMongoDaoImpl ticketMongoDao,
                                      MongoEntityConverter mongoEntityConverter) {
        this.eventSqlDao = eventSqlDao;
        this.userSqlDao = userSqlDao;
        this.ticketSQLDao = ticketSQLDao;
        this.eventMongoDao = eventMongoDao;
        this.userMongoDao = userMongoDao;
        this.ticketMongoDao = ticketMongoDao;
        this.mongoEntityConverter = mongoEntityConverter;
    }


    @Transactional
    public void getSqlData() {
        eventEntityList = eventSqlDao.getAllEventEntity();
        userEntityList = userSqlDao.getAllUserEntity();
        ticketEntityList = ticketSQLDao.getAllTicketEntity();
    }

    @Transactional
    public void migrateDataToMongo() {
        List<EventMongoEntity> eventMongoEntities = new ArrayList<>();
        List<UserMongoEntity> userMongoEntities = new ArrayList<>();
        List<TicketMongoEntity> ticketMongoEntities = new ArrayList<>();
        for (EventEntity event : eventEntityList) {
            eventMongoEntities.add(mongoEntityConverter.convertEntityToMongoEntity(event));
        }
        for (UserEntity user : userEntityList) {
            userMongoEntities.add(mongoEntityConverter.convertEntityToMongoEntity(user));
        }
        for (TicketEntity ticket : ticketEntityList) {
            EventMongoEntity eventMongoEntity = null;
            UserMongoEntity userMongoEntity = null;
            for (int i = 0; i < eventMongoEntities.size(); i++) {
                if (eventMongoEntities.get(i).getId() == ticket.getEventId()) {
                    eventMongoEntity = eventMongoEntities.get(i);
                    break;
                }
            }
            for (int i = 0; i < userMongoEntities.size(); i++) {
                if (userMongoEntities.get(i).getId() == ticket.getUserId()) {
                    userMongoEntity = userMongoEntities.get(i);
                    break;
                }
            }
            if (eventMongoEntity == null || userMongoEntity == null) {
                throw new IllegalArgumentException("Ticket have event or userId, that doesn't exist");
            }
            ticketMongoEntities.add(mongoEntityConverter.convertEntityToMongoEntity(ticket, eventMongoEntity, userMongoEntity));
        }
        //adding data to MongoDB
        for (int i = 0; i < eventMongoEntities.size(); i++) {
            eventMongoDao.insert(eventMongoEntities.get(i));
        }
        for (int i = 0; i < userMongoEntities.size(); i++) {
            userMongoDao.insert(userMongoEntities.get(i));
        }
        for (int i = 0; i < ticketMongoEntities.size(); i++) {
            ticketMongoDao.insert(ticketMongoEntities.get(i));
        }
    }
}
