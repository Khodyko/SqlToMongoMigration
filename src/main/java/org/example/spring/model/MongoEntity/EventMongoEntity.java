package org.example.spring.model.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "eventEntity")
public class EventMongoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Indexed(name = "first_name_index")
    private String title;
    private Date date;

    public EventMongoEntity(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public EventMongoEntity() {
    }

    public EventMongoEntity(long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventMongoEntity)) return false;
        EventMongoEntity that = (EventMongoEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventMongoEntity{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
