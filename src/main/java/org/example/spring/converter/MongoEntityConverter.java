package org.example.spring.converter;

import org.example.spring.model.Entity.EventEntity;
import org.example.spring.model.Entity.TicketEntity;
import org.example.spring.model.Entity.UserEntity;
import org.example.spring.model.MongoEntity.EventMongoEntity;
import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.example.spring.model.MongoEntity.UserMongoEntity;

public class MongoEntityConverter {
    public EventMongoEntity convertEntityToMongoEntity(EventEntity EventEntity){
        EventMongoEntity eventMongoEntity=new EventMongoEntity(EventEntity.getId(),EventEntity.getTitle(),EventEntity.getDate());
        return eventMongoEntity;
    }

    public UserMongoEntity convertEntityToMongoEntity(UserEntity userEntity){
        UserMongoEntity userMongoEntity=new UserMongoEntity(userEntity.getId(),userEntity.getName(),userEntity.getEmail());
        return userMongoEntity;
    }

    public TicketMongoEntity convertEntityToMongoEntity(TicketEntity ticketEntity, EventMongoEntity eventMongoEntity, UserMongoEntity userMongoEntity){
        TicketMongoEntity ticketMongoEntity=new TicketMongoEntity(ticketEntity.getId(),eventMongoEntity,userMongoEntity, ticketEntity.getCategory().getName(),ticketEntity.getPlace());
        return ticketMongoEntity;
    }

}
