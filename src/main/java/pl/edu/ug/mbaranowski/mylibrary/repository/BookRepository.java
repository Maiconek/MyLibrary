package pl.edu.ug.mbaranowski.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
