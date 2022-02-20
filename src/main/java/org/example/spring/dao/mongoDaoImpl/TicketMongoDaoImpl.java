package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.MongoEntity.TicketMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public class TicketMongoDaoImpl implements MongoRepository<TicketMongoEntity, Long> {
    private MongoTemplate template;

    public TicketMongoDaoImpl() {
    }

    @Autowired
    public TicketMongoDaoImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public <S extends TicketMongoEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TicketMongoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<TicketMongoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<TicketMongoEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TicketMongoEntity ticketMongoEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TicketMongoEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TicketMongoEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TicketMongoEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> S insert(S ticketMongoEntity) {
        template.insert(ticketMongoEntity);
        return ticketMongoEntity;
    }

    @Override
    public <S extends TicketMongoEntity> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TicketMongoEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TicketMongoEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TicketMongoEntity> boolean exists(Example<S> example) {
        return false;
    }
}
