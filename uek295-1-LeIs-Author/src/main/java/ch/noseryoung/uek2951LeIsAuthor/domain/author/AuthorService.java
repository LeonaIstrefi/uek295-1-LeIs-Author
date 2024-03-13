package ch.noseryoung.uek2951LeIsAuthor.domain.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getAuthor(Integer authorID) throws AuthorNotFoundException {
        return repository.findById(authorID).orElseThrow(() -> new AuthorNotFoundException("Couldn't find author"));
    }

    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    public Author updateAuthor(int ID, Author author) {
       return repository.save(author);
    }

    public void deleteAuthor(Integer authorID) throws NoSuchElementException {
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
