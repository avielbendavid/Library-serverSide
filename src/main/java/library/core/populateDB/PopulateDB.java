package library.core.populateDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class PopulateDB implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
	}
	
//	
//	private BookRepository bookRepository;
//	private LibraryRepository libraryRepository;
//	private CustomerRepository customerRepository;
//	private CustomerService customerService;
//	
//
//	public PopulateDB(BookRepository bookRepository, LibraryRepository libraryRepository,
//			CustomerRepository customerRepository, CustomerService customerService) {
//		super();
//		this.bookRepository = bookRepository;
//		this.libraryRepository = libraryRepository;
//		this.customerRepository = customerRepository;
//		this.customerService = customerService;
//	}
//
//
//	@Override
//	public void run(String... args) throws Exception {
//		Book b1 = new Book("aaa",5,Double.valueOf(5));
//		Library l1 = new Library("Bat-Yam");
//		l1.addBook(b1);
//		System.out.println("111");
//		libraryRepository.save(l1);
//		Customer c1 = new Customer("Itzhak",55);
//		customerRepository.save(c1);
//		Book b1 = bookRepository.findById(1).get();
//		Customer c1 = customerRepository.findById(1).get();
//		
//		c1.addBook(b1);
//		this.customerService.purchaseBook(b1, c1.getId());
//		System.out.println(b1);
//		System.out.println(c1);
		
		
	}
	
	
	


