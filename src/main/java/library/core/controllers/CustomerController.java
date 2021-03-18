package library.core.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.core.entities.Book;
import library.core.exceptions.LibrarySystemException;
import library.core.services.CustomerService;
import library.core.session.SessionContext;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {

	private SessionContext sessionContext;

	public CustomerController(SessionContext sessionContext) {
		super();
		this.sessionContext = sessionContext;
	}

	@GetMapping(path = "/get-all-customer-books")
	public ResponseEntity<?> getAllCustomerBooks(@RequestHeader String token) throws LibrarySystemException {
		CustomerService customerService = (CustomerService) this.sessionContext.getSession(token)
				.getAttributes("service");
		try {
			List<Book> customerBooks = customerService.getAllCustomerBooks();
			return ResponseEntity.ok().body(customerBooks);
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, can not get the books --->>> " + e.getMessage());
		}

	}

}
