package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "Author")
public class Author {
    @Id

    @NotNull
    private Integer Id;

    private String birthday;

    private String Name;

    @Column
    private String ProfilePicture;


}
