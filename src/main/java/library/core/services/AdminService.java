package library.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import library.core.entities.Library;
import library.core.exceptions.LibrarySystemException;
import library.core.repositories.LibraryRepository;

@Service
@Transactional
public class AdminService extends ClientService {

	private String email;
	private String password;
	private LibraryRepository libraryRepository;

	public AdminService(@Value("${adminEmail}") String email, @Value("${adminPassword}") String password) {
		super();
		this.email = email;
		this.password = password;
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

}
