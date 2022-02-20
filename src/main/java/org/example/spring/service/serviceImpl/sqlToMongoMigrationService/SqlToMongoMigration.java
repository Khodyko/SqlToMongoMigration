package org.example.spring.service.serviceImpl.sqlToMongoMigrationService;

public interface SqlToMongoMigration {
    public void getSqlData();
    public void migrateDataToMongo();
}
