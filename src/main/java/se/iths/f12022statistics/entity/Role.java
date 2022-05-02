package se.iths.f12022statistics.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    private Long id;

    @Column(length = 60)
    private String name;

}
