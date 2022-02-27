package org.example.spring.converter;

import org.example.spring.model.Entity.EventEntity;
import org.example.spring.model.Entity.TicketEntity;
import org.example.spring.model.Entity.UserEntity;
import org.example.spring.model.MongoEntity.EventMongoEntity;
import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.example.spring.model.MongoEntity.UserMongoEntity;

public class MongoEntityConverter {
    public EventMongoEntity convertEntityToMongoEntity(EventEntity eventEntity) {
     return new EventMongoEntity(eventEntity.getId(),
                                            eventEntity.getTitle(), eventEntity.getDate());
    }

    public UserMongoEntity convertEntityToMongoEntity(UserEntity userEntity) {
       return new UserMongoEntity(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }

    public TicketMongoEntity convertEntityToMongoEntity(TicketEntity ticketEntity,
                                                        EventMongoEntity eventMongoEntity,
                                                        UserMongoEntity userMongoEntity) {
      return new TicketMongoEntity(ticketEntity.getId(), eventMongoEntity, userMongoEntity,
                                     ticketEntity.getCategory().getName(), ticketEntity.getPlace());
    }
}
