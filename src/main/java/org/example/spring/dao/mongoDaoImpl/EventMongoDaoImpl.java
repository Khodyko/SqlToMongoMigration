package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.MongoEntity.EventMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public class EventMongoDaoImpl implements MongoRepository<EventMongoEntity, Long> {


    private MongoTemplate template;

    @Autowired
    public EventMongoDaoImpl(MongoTemplate template) {
        this.template = template;
    }


    public EventMongoDaoImpl() {
    }


    @Override
    public <S extends EventMongoEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<EventMongoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


    @Override
    public List<EventMongoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<EventMongoEntity> findAllById(Iterable<Long> iterable) {
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
    public void delete(EventMongoEntity eventMongoEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends EventMongoEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<EventMongoEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<EventMongoEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> S insert(S eventMongoEntity) {
        template.insert(eventMongoEntity);
        return eventMongoEntity;
    }

    @Override
    public <S extends EventMongoEntity> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EventMongoEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventMongoEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EventMongoEntity> boolean exists(Example<S> example) {
        return false;
    }


}
