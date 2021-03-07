package library.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import library.core.entities.Book;
import library.core.entities.Library;
import library.core.services.AdminService;


@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);
		AdminService adminService = ctx.getBean(AdminService.class);
		System.out.println(adminService);
		Library l1 =adminService.addBook(new Book(), 1);
		System.out.println(l1);
		System.out.println(l1.getBooks());
	}

}
