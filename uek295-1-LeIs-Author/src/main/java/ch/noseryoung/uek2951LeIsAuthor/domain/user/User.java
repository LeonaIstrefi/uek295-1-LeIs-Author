package ch.noseryoung.uek2951LeIsAuthor.domain.user;


import ch.noseryoung.uek2951LeIsAuthor.domain.authority.Authority;
import ch.noseryoung.uek2951LeIsAuthor.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "author_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "role", referencedColumnName = "role_id")
    private Role role;
}