package library.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import library.core.entities.Book;
import library.core.entities.Customer;
import library.core.entities.Library;
import library.core.exceptions.LibrarySystemException;
import library.core.repositories.BookRepository;
import library.core.repositories.CustomerRepository;
import library.core.repositories.LibraryRepository;

@Service
@Transactional
public class AdminService extends ClientService {

	private String email;
	private String password;
	private LibraryRepository libraryRepository;
	private BookRepository bookRepository;
	private CustomerRepository customerRepository;

	public AdminService(@Value("${adminEmail}") String email, @Value("${adminPassword}") String password,
			LibraryRepository libraryRepository, BookRepository bookRepository, CustomerRepository customerRepository) {
		super();
		this.email = email;
		this.password = password;
		this.libraryRepository = libraryRepository;
		this.bookRepository = bookRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public boolean login(String email, String password) throws LibrarySystemException {
		if (this.email.equals(email) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public void addLibrary(Library library) throws LibrarySystemException {
		if (this.libraryRepository.existsByName(library.getName())) {
			throw new LibrarySystemException(
					"Sorry, can not add this library because there is already a library with the same name");
		}
		this.libraryRepository.save(library);
	}

	public void addBook(Book book, Integer libraryId) {
		Library libraryFromDB = this.libraryRepository.findById(libraryId).get();
		System.out.println(libraryFromDB);
		libraryFromDB.addBook(book);
	}

	public void addCustomer(Customer customer) throws LibrarySystemException {
		if (!this.customerRepository.existsByEmail(customer.getEmail())) {
			customerRepository.save(customer);
		} else {
			throw new LibrarySystemException(
					"Sorry, can not add this customer because there is already a customer that using the same email address");
		}
	}

	public void deleteBook(Integer bookId) throws LibrarySystemException {
		try {
			this.bookRepository.deleteById(bookId);
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not delete the book", e);
		}
	}

	public void deleteLibrary(Integer libraryId) throws LibrarySystemException {
		try {
			this.libraryRepository.deleteById(libraryId);
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not delete library --->>> " + e.getMessage(), e);
		}
	}

	public void deleteCustomer(int id) throws LibrarySystemException {
		try {
			this.customerRepository.deleteById(id);
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not delete this customer --->>>", e);
		}
	}

	public List<Library> getAllLibraries() throws LibrarySystemException {
		try {
			return this.libraryRepository.findAll();
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not get all libraries --->>> ", e);
		}
	}

	public List<Customer> getAllCustomers() throws LibrarySystemException {
		try {
			return this.customerRepository.findAll();
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not get all customers --->>> ", e);
		}
	}

	public List<Book> getAllBooks() throws LibrarySystemException {
		try {
			return this.bookRepository.findAll();
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not get all books --->>> ", e);
		}
	}

}
