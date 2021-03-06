package library.core.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import library.core.entities.Book;
import library.core.entities.Customer;
import library.core.exceptions.LibrarySystemException;
import library.core.repositories.BookRepository;
import library.core.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	private BookRepository bookRepository;
	private CustomerRepository customerRepository;

	public CustomerService(BookRepository bookRepository, CustomerRepository customerRepository) {
		super();
		this.bookRepository = bookRepository;
		this.customerRepository = customerRepository;
	}

	public void purchaseBook(Book book, Integer customerId) throws LibrarySystemException {
		Optional<Customer> opt = this.customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer currCustomer = opt.get();
			if (customerRepository.existsByIdAndBooksId(customerId, book.getId())) {
				throw new LibrarySystemException("Sorry, can not purchase this book [id:" + book.getId()
						+ "] because customer already purchased this book");
			}
			Book book2 = bookRepository.findById(book.getId()).get();
			currCustomer.addBook(book2);
		}
	}

	public void returnBook(Book book, Integer customerId) throws LibrarySystemException {
		Optional<Customer> opt = this.customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer currCustomer = opt.get();
			if (customerRepository.existsByIdAndBooksId(customerId, book.getId())) {
				currCustomer.removeBook(book);
			}
			else {
				throw new LibrarySystemException("Sorry, can not return this book [id:" + book.getId()
				+ "] because customer do not have purchased this book");
			}
		}
	}

}
