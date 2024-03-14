package ch.noseryoung.uek2951LeIsAuthor.domain.authority;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "authority_id")
    private int id;

    @Column(name = "name")
    private String name;
}
