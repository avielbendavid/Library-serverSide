package library.core.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import library.core.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
