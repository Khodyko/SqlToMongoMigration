package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.MongoEntity.EventMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


public class EventMongoDaoImpl  {


    private MongoTemplate template;

    @Autowired
    public EventMongoDaoImpl(MongoTemplate template) {
        this.template = template;
    }


    public EventMongoDaoImpl() {
    }

    public <S extends EventMongoEntity> S insert(S eventMongoEntity) {
        template.insert(eventMongoEntity);
        return eventMongoEntity;
    }

}
