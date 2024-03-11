package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "Author")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    private Integer Id;

    private String birthday;

    private String Name;

    @Column
    private String ProfilePicture;


}
