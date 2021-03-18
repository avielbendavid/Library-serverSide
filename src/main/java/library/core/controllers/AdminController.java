package library.core.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.core.entities.Book;
import library.core.entities.Customer;
import library.core.entities.Library;
import library.core.exceptions.LibrarySystemException;
import library.core.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@GetMapping(path = "/get-all-libraries")
	public ResponseEntity<?> getAllLibraries() {
		try {
			List<Library> libraries = this.adminService.getAllLibraries();
			return ResponseEntity.ok().body(libraries);
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to get all libraries --->>> " + e.getMessage());
		}
	}

	@GetMapping(path = "/get-all-customers")
	public ResponseEntity<?> getAllCustomers() {
		try {
			List<Customer> customers = this.adminService.getAllCustomers();
			return ResponseEntity.ok().body(customers);
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to get all customers --->>> " + e.getMessage());
		}
	}

	@GetMapping(path = "/get-all-books")
	public ResponseEntity<?> getAllBooks() {
		try {
			List<Book> books = this.adminService.getAllBooks();
			return ResponseEntity.ok().body(books);
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to get all books --->>> " + e.getMessage());
		}
	}

	@PostMapping(path = "/add-library")
	public ResponseEntity<?> addLibrary(@RequestBody Library library) {
		try {
			this.adminService.addLibrary(library);
			return ResponseEntity.ok("Library added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to get all libraries --->>> " + e.getMessage());
		}
	}

	@PostMapping(path = "/add-customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {
			this.adminService.addCustomer(customer);
			return ResponseEntity.ok("Customer added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to add the customer --->>> " + e.getMessage());
		}
	}

	@PostMapping(path = "/add-book/{libraryId}")
	public ResponseEntity<?> addBook(@RequestBody Book book,int libraryId) {
		try {
			this.adminService.addBook(book,libraryId);
			return ResponseEntity.ok("book added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to add the book --->>> " + e.getMessage());
		}
	}

	@DeleteMapping(path = "/delete-library/{id}")
	public ResponseEntity<?> deleteLibrary(@PathVariable int id) {
		try {
			this.adminService.deleteLibrary(id);
			return ResponseEntity.ok().body("Library deleted successfully");
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to delete the library --->>> " + e.getMessage());
		}
	}

	@DeleteMapping(path = "/delete-customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			this.adminService.deleteCustomer(id);
			return ResponseEntity.ok("Delete customer [id:" + id + "] was successfull");
		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to delete this customer --->>> " + e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/delete-book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		try {
			this.adminService.deleteBook(id);
			return ResponseEntity.ok("Delete book [id:" + id + "] was successfull");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, there was a problem while trying to delete this customer --->>> " + e.getMessage());
		}
	}

}
