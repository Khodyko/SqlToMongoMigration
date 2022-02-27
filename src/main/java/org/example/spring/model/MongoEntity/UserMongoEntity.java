package org.example.spring.model.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "userEntity")
public class UserMongoEntity {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;
    private String email;

    public UserMongoEntity(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserMongoEntity() {
    }

    public UserMongoEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMongoEntity)) return false;
        UserMongoEntity that = (UserMongoEntity) o;
        return id == that.id && Objects.equals(name, that.name)
                             && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserMongoEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
