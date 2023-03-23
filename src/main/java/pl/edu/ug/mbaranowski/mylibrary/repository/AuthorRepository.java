package pl.edu.ug.mbaranowski.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a from Author a")
    List<Author> getAllAuthors();
}
