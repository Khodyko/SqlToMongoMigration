package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.Entity.TicketEntity;
import org.example.spring.model.Entity.UserEntity;
import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TicketMongoDaoImpl {
    private MongoTemplate template;

    public TicketMongoDaoImpl() {
    }

    @Autowired
    public TicketMongoDaoImpl(MongoTemplate template) {

        this.template = template;
    }

    public TicketMongoEntity insert(TicketMongoEntity ticketMongoEntity) {
        template.insert(ticketMongoEntity);
        return ticketMongoEntity;
    }
    Criteria criteria = Criteria
            .where("eventMongoEntity.id").is(1)
            .and("userMongoEntity.id").is(2);

    public TicketEntity getAggregationTicketCount() {
        ProjectionOperation projectionOperation=project("_id")
                .and("eventMongoEntity._id").as("eventId")
                .and("userMongoEntity._id").as("userId")
                .andInclude("category", "place");
        Aggregation aggregation = newAggregation(projectionOperation);

        AggregationResults<TicketEntity> results=template.aggregate(aggregation,"ticketEntity", TicketEntity.class);
        return results.getMappedResults().get(1);
    }

}
