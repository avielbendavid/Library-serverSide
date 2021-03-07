package library.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import library.core.services.AdminService;


@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);
		AdminService adminService = ctx.getBean(AdminService.class);
		adminService.f();
	}

}
