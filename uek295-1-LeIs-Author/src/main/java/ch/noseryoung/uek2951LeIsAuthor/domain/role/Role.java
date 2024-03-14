package ch.noseryoung.uek2951LeIsAuthor.domain.role;


import ch.noseryoung.uek2951LeIsAuthor.domain.authority.Authority;
import ch.noseryoung.uek2951LeIsAuthor.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "role_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_role_authority",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_authority", referencedColumnName = "authority_id")
            }
    )
    private Set<Authority> authoritySet;

}