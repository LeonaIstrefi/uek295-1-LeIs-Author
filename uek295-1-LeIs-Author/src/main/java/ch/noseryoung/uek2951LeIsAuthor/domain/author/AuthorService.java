package ch.noseryoung.uek2951LeIsAuthor.domain.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getAuthor(Integer authorID) {
        return repository.findById(authorID).orElse(null);
    }

    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    public void updateAuthor(int ID, Author author) {
         repository.save(author);
    }

    public void deleteAuthor(Integer authorID) {
        repository.deleteById(authorID);
    }

}
