package library.core.services;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import library.core.entities.Book;
import library.core.entities.Library;
import library.core.repositories.BookRepository;

@Component
@Service
public class CustomerService {
//	private BookRepository bookRepository;
//	private Library library;
//
//	public CustomerService(BookRepository bookRepository) {
//		super();
//		this.bookRepository = bookRepository;
//	}
//
//	public boolean askForBook(Book book) {
//		Optional<Book> opt = this.bookRepository.findById(book.getId());
//		if (opt.isPresent()) {
//			boolean removed = this.library.removeBook(book);
//			if (removed) {
//				return true;
//			}
//		}
//		return false;
//	}
}
