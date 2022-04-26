package se.iths.f12022statistics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
