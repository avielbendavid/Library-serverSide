package library.core.exceptions;

public class LibrarySystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibrarySystemException() {
		super();
	}

	public LibrarySystemException(String message) {
		super(message);
	}

	public LibrarySystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
