package library.core.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping(path = "/greet")
	private String greet() {
		return "Hello from greet method!";
	}


}
