package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.MongoEntity.UserMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class UserMongoDaoImpl {
    private MongoTemplate template;

    public UserMongoDaoImpl() {
    }

    @Autowired
    public UserMongoDaoImpl(MongoTemplate template) {
        this.template = template;
    }

    public <S extends UserMongoEntity> S insert(S userMongoEntity) {
        template.insert(userMongoEntity);
        return userMongoEntity;
    }


}
