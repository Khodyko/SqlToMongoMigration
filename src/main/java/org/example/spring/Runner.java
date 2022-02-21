package org.example.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.spring.dao.mongoDaoImpl.TicketMongoDaoImpl;
import org.example.spring.service.serviceImpl.sqlToMongoMigrationService.SqlToMongoMigrationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;

import static org.apache.logging.log4j.Level.DEBUG;

public class Runner {
    private final static Logger logger = LogManager.getLogger();

    public Runner() {
        logger.log(DEBUG, this.getClass().getSimpleName() + " was created");
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlToMongoMigrationService sqlToMongoMigrationService=ctx.getBean(SqlToMongoMigrationService.class);
        sqlToMongoMigrationService.getSqlData();
        sqlToMongoMigrationService.migrateDataToMongo();

        TicketMongoDaoImpl ticketMongoDao=ctx.getBean(TicketMongoDaoImpl.class);
        System.out.println("!!!!!!!!!!!!!!!!11count of tickets: "+ticketMongoDao.getAggregationTicketCount());

    }
}
