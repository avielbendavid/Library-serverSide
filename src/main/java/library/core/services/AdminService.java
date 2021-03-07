package library.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import library.core.entities.Book;
import library.core.entities.Library;
import library.core.exceptions.LibrarySystemException;
import library.core.repositories.LibraryRepository;

@Service
@Transactional
public class AdminService extends ClientService {

	private String email;
	private String password;
	private LibraryRepository libraryRepository;

	public AdminService(@Value("${adminEmail}") String email, @Value("${adminPassword}") String password,LibraryRepository libraryRepository) {
		super();
		this.email = email;
		this.password = password;
		this.libraryRepository = libraryRepository;
	}


	@Override
	boolean login(String email, String password) throws LibrarySystemException {
		return false;
	}

	public void addLibrary(Library library) throws LibrarySystemException {
		if (this.libraryRepository.existsByName(library.getName())) {
			throw new LibrarySystemException(
					"Sorry, can not add this library because there is already a library with the same name");
		}
		this.libraryRepository.save(library);
	}

	public void removeLibrary(Integer libraryId) throws LibrarySystemException {
		try {
			this.libraryRepository.deleteById(libraryId);
		} catch (Exception e) {
			throw new LibrarySystemException("Sorry, can not delete library --->>> " + e.getMessage(), e);
		}
	}

	public void addBook(Book book, Integer libraryId) {
	   Library currLibrary = this.libraryRepository.findById(libraryId).get();
	   currLibrary.addBook(book);
	}

	public void removeBook(Book book, Integer libraryId) {

	}
}
