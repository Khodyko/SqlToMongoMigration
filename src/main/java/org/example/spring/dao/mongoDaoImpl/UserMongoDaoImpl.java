package org.example.spring.dao.mongoDaoImpl;

import org.example.spring.model.MongoEntity.UserMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class UserMongoDaoImpl implements MongoRepository<UserMongoEntity, Long> {
    private MongoTemplate template;

    public UserMongoDaoImpl() {
    }

    @Autowired
    public UserMongoDaoImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public <S extends UserMongoEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserMongoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<UserMongoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<UserMongoEntity> findAllById(Iterable<Long> iterable) {
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
    public void delete(UserMongoEntity userMongoEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserMongoEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserMongoEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserMongoEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> S insert(S userMongoEntity) {
        template.insert(userMongoEntity);
        return userMongoEntity;
    }

    @Override
    public <S extends UserMongoEntity> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserMongoEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserMongoEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserMongoEntity> boolean exists(Example<S> example) {
        return false;
    }
}
