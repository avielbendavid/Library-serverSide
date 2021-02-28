package library.core.populateDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import library.core.entities.Book;
import library.core.entities.Library;
import library.core.repositories.BookRepository;
import library.core.repositories.LibraryRepository;

@Component
public class PopulateDB  implements CommandLineRunner{
	
	
	private BookRepository bookRepository;
	private LibraryRepository libraryRepository;

	


	public PopulateDB(BookRepository bookRepository, LibraryRepository libraryRepository) {
		super();
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
	}




	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book("aaa",5,Double.valueOf(5));
		Library l1 = new Library("Bat-Yam");
		l1.addBook(b1);
		System.out.println("111");
		libraryRepository.save(l1);
		
	}
	
	
	

}
