package ch.noseryoung.uek2951LeIsAuthor.domain.author;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/author")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "get all Authors",
            description = "With this endpoint you get all Authors")
    public ResponseEntity<List<Author>> getAuthor()  {
        return ResponseEntity.ok().body(service.getAuthors());
    }

    @GetMapping("/{authorID}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "get one specific Auther by id",
            description = "With this endpoint, you get one specific Author by id")
    public ResponseEntity<Author> readAuthor(@PathVariable("authorID") Integer authorID) throws AuthorNotFoundException, InstanceNotFoundException, AuthorService.AuthorNotFoundException {
        return ResponseEntity.ok().body(service.getAuthor(authorID));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(summary = "create Author",
            description = "Creates a new Author")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author newauthor) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(201).body(service.createAuthor(newauthor));


    }

    @PutMapping("/{authorID}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "updates Authors",
            description = "It updates Authors by id")
    public ResponseEntity<Author> updateAuthor(@Valid @PathVariable("authorID")int authorID, @RequestBody Author author) throws InstanceNotFoundException {
        return ResponseEntity.status(200).body(service.updateAuthor(authorID, author));

    }

    @DeleteMapping("/{authorID}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Delete Author",
            description = "Deletes Auther by id")
    public void deleteAuthor(@Valid @PathVariable("authorID") Integer AuthorId) throws AuthorNotFoundException, InstanceNotFoundException {
        service.deleteAuthor(AuthorId);
    }

    public class AuthorNotFoundException extends Exception{
        public AuthorNotFoundException(String message){
            super(message);
        }

        public AuthorNotFoundException() {
            super();
        }
    }

    @ExceptionHandler(AuthorService.AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorServiceAuthorNotFoundException(AuthorService.AuthorNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorNotFoundException(AuthorNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> hanldeNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> handleInstanceAlreadyExistsException(InstanceAlreadyExistsException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(AuthorController.AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorControllerAuthorNotFoundException(AuthorController.AuthorNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }







}