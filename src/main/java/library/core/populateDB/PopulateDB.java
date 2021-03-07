package library.core.populateDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import library.core.entities.Book;
import library.core.entities.Customer;
import library.core.entities.Library;
import library.core.repositories.BookRepository;
import library.core.repositories.CustomerRepository;
import library.core.repositories.LibraryRepository;
import library.core.services.CustomerService;


//@Component
public class PopulateDB implements CommandLineRunner{

	
	
	
	private BookRepository bookRepository;
	private LibraryRepository libraryRepository;
	private CustomerRepository customerRepository;
	private CustomerService customerService;
	

	public PopulateDB(BookRepository bookRepository, LibraryRepository libraryRepository,
			CustomerRepository customerRepository, CustomerService customerService) {
		super();
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
		this.customerRepository = customerRepository;
		this.customerService = customerService;
	}


	@Override
	public void run(String... args) throws Exception {
//		Book b1 = new Book("aaa",5,Double.valueOf(5),90);
//		Library l1 = new Library("Bat-Yam");
//		l1.addBook(b1);
//		System.out.println("111");
//		libraryRepository.save(l1);
//		Customer c1 = new Customer("Itzhak",55);
//		customerRepository.save(c1);
//		Book b2 = bookRepository.findById(1).get();
//		Customer c2 = customerRepository.findById(1).get();
//		
//		this.customerService.purchaseBook(b2, c2.getId());
//		System.out.println(b2);
//		System.out.println(c2);
		
		
	}
}
	
	


