package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.Entity.TicketEntity;
import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

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

    public List<TicketEntity> getAggregationToTicketEntityList() {
        ProjectionOperation projectionOperation = project("_id")
                .and("eventMongoEntity._id").as("eventId")
                .and("userMongoEntity._id").as("userId")
                .andInclude("category", "place");
        Aggregation aggregation = newAggregation(projectionOperation);
        AggregationResults<TicketEntity> results = template.aggregate(aggregation,
                                        "ticketEntity", TicketEntity.class);
        return results.getMappedResults();
    }

}
