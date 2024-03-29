package library.core.services;

import java.util.List;
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
public class CustomerService extends ClientService {

	private BookRepository bookRepository;
	private CustomerRepository customerRepository;
	private Integer customerId;

	public CustomerService(BookRepository bookRepository, CustomerRepository customerRepository) {
		super();
		this.bookRepository = bookRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public boolean login(String email, String password) throws LibrarySystemException {
		try {
			Optional<Customer> opt = this.customerRepository.findByEmailAndPassword(email, password);
			if (opt.isPresent()) {
				Customer customerFromDB = opt.get();
				this.customerId = customerFromDB.getId();
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new LibrarySystemException("There was an error while trying to login --->>> " + e.getMessage(), e);
		}
	}

	public void purchaseBook(Book book) throws LibrarySystemException {
		try {
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
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not purchase this book [id:" + book.getId()
					+ "] because there was a problem while trying to purchase this book", e);
		}
	}

	public void returnBook(Book book) throws LibrarySystemException {
		try {
			Optional<Customer> opt = this.customerRepository.findById(customerId);
			if (opt.isPresent()) {
				Customer currCustomer = opt.get();
				if (customerRepository.existsByIdAndBooksId(customerId, book.getId())) {
					currCustomer.removeBook(book);
				} else {
					throw new LibrarySystemException("Sorry, can not return this book [id:" + book.getId()
							+ "] because customer do not have purchased this book");
				}
			}
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not return this book [id:" + book.getId()
					+ "] because there was a problem while trying to return this book", e);
		}
	}

	public List<Book> getAllCustomerBooks() throws LibrarySystemException {
		Optional<Customer> opt = this.customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer customerFromDB = opt.get();
			return customerFromDB.getBooks();
		} else {
			throw new LibrarySystemException("Sorry, can not get customer Books because the customer does not exists");
		}
	}

}
