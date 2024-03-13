package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthor() {
        return ResponseEntity.ok().body(service.getAuthors());
    }

    @GetMapping("/{authorID}")
    public ResponseEntity<Author> readAuthor(@PathVariable("authorID") Integer authorID) {
        return ResponseEntity.ok().body(service.getAuthor(authorID));
    }

    @PostMapping
    public void createAuthor(@Valid @RequestBody Author author) {
        service.createAuthor(author);
    }

    @PutMapping
    public void updateAuthor(@Valid @PathVariable("authorID")int authroID, @RequestBody Author author) {
        service.updateAuthor(authroID, author);
    }

    @DeleteMapping("/{authorID}")
    public void deleteAuthor(@Valid @PathVariable ("authorID") Integer AuthorId) {

        service.deleteAuthor(AuthorId);
    }

}
