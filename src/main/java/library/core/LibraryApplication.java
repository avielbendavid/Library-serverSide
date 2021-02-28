package library.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import library.core.services.CustomerService;

@Configuration
@ComponentScan
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LibraryApplication.class);
	Object c =ctx.getBean(CustomerService.class);
	System.out.println(c);
	System.out.println("Bye Bye");
	}

}
