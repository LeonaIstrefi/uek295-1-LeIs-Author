package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

@RequestMapping("/author")
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

    @PostMapping("/{authorID}")
    public ResponseEntity<Author> createAuthor(@RequestBody Author newauthor) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(201).body(service.createAuthor(newauthor));


    }

    @PutMapping("/{authorID}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("authorID")int authorID, @RequestBody Author author) throws InstanceNotFoundException {
        return ResponseEntity.status(200).body(service.updateAuthor(authorID, author));

    }

    @DeleteMapping("/{authorID}")
    public String deleteAuthor(@PathVariable("authorID") Integer AuthorId) {
        service.deleteAuthor(AuthorId);
        return "The id " + AuthorId + " has been deleted ";
    }

}
