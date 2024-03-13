package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.NoSuchFileException;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "author")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @NotNull
    @Column(name = "author_id")
    private Integer Id;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "name")
    private String Name;

    @Column(name = "profile_picture")
    private String profile_picture;


    public Author(Integer id, String birthday, String name, String profile_picture) {
        setId(id);
        setBirthday(birthday);
        setName(name);
        setProfile_picture(profile_picture);
    }

}
