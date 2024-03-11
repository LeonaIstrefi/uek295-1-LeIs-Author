package ch.noseryoung.uek2951LeIsAuthor.domain.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Integer> {
}
