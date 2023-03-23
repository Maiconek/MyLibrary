package pl.edu.ug.mbaranowski.mylibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;
import pl.edu.ug.mbaranowski.mylibrary.repository.AuthorRepository;
import pl.edu.ug.mbaranowski.mylibrary.repository.BookRepository;

@SpringBootApplication
public class MylibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			Book book = new Book("Hunger Games", "Suzanne Collins", 2008);
			Book book2 = new Book("Szybko, Szybciej, Najszybciej", "Mikołaj Sokół", 2022);
			Author author = new Author("Suzanne", "Collins", 1962, "US");
			System.out.println("Inserting data...");
			bookRepository.save(book);
			bookRepository.save(book2);
			authorRepository.save(author);
		};
	}

}
