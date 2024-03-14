package ch.noseryoung.uek2951LeIsAuthor.domain.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getAuthor(Integer authorID) throws AuthorController.AuthorNotFoundException, AuthorService.AuthorNotFoundException, InstanceNotFoundException {
        return repository.findById(authorID).orElseThrow(() -> new AuthorNotFoundException("Couldn't find author"));
    }

    public Author createAuthor(Author author) throws InstanceAlreadyExistsException {
        return repository.save(author);
    }

    public Author updateAuthor(int ID, Author author)throws InstanceNotFoundException {
       return repository.save(author);
    }

    public void deleteAuthor(Integer authorID) throws AuthorController.AuthorNotFoundException, NoSuchElementException, InstanceNotFoundException {
       if (!repository.existsById(authorID)) {
           throw new InstanceNotFoundException("The id " + authorID + " has been deleted");
        }

        repository.deleteById(authorID);
    }

    public class AuthorNotFoundException extends Exception{
        public AuthorNotFoundException(String message){
            super(message);
        }
        public AuthorNotFoundException() {
            super();
        }
    }


}
