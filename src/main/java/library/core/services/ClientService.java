package library.core.services;

import library.core.exceptions.LibrarySystemException;

public abstract class ClientService {

	abstract boolean login(String email,String password) throws LibrarySystemException;
}
