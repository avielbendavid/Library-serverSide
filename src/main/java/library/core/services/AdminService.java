package library.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import library.core.exceptions.LibrarySystemException;

@Service
@Transactional
public class AdminService extends ClientService {

	private String email;
	private String password;

	public AdminService(@Value("${adminEmail}") String email, @Value("${adminPassword}") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	boolean login(String email, String password) throws LibrarySystemException {
		return false;
	}

}
