package library.core.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import library.core.entities.Book;
import library.core.entities.Customer;
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

	
	
	
	public boolean purchaseBook(Book book,Integer customerId) {
	 Optional<Customer> opt =  this.customerRepository.findById(customerId);
	 if(opt.isPresent()) {
	 		Customer currCustomer = opt.get();
//	 		if(custom)
	 		Book book2 = bookRepository.findById(book.getId()).get();
	 		currCustomer.addBook(book2);
	 		return true;
	 	}
	return false;
	}
	
}
