package org.example.spring.model.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "ticketEntity")
public class TicketMongoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private EventMongoEntity eventMongoEntity;
    private UserMongoEntity userMongoEntity;
    private String category;
    private int place;

    public TicketMongoEntity() {
    }

    public TicketMongoEntity(EventMongoEntity eventMongoEntity, UserMongoEntity userMongoEntity, String category, int place) {
        this.eventMongoEntity = eventMongoEntity;
        this.userMongoEntity = userMongoEntity;
        this.category = category;
        this.place = place;
    }

    public TicketMongoEntity(long id, EventMongoEntity eventMongoEntity, UserMongoEntity userMongoEntity, String category, int place) {
        this.id = id;
        this.eventMongoEntity = eventMongoEntity;
        this.userMongoEntity = userMongoEntity;
        this.category = category;
        this.place = place;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TicketMongoEntity{");
        sb.append("id=").append(id);
        sb.append(", eventMongoEntity=").append(eventMongoEntity);
        sb.append(", userMongoEntity=").append(userMongoEntity);
        sb.append(", category='").append(category).append('\'');
        sb.append(", place=").append(place);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketMongoEntity)) return false;
        TicketMongoEntity that = (TicketMongoEntity) o;
        return id == that.id && place == that.place
                             && Objects.equals(eventMongoEntity, that.eventMongoEntity)
                             && Objects.equals(userMongoEntity, that.userMongoEntity)
                             && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventMongoEntity, userMongoEntity, category, place);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EventMongoEntity getEventMongoEntity() {
        return eventMongoEntity;
    }

    public void setEventMongoEntity(EventMongoEntity eventMongoEntity) {
        this.eventMongoEntity = eventMongoEntity;
    }

    public UserMongoEntity getUserMongoEntity() {
        return userMongoEntity;
    }

    public void setUserMongoEntity(UserMongoEntity userMongoEntity) {
        this.userMongoEntity = userMongoEntity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
