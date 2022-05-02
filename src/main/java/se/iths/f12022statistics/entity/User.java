package se.iths.f12022statistics.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
