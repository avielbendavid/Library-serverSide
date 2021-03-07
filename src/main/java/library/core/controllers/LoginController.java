package library.core.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.core.enums.ClientType;
import library.core.exceptions.LibrarySystemException;
import library.core.login.manager.LoginManager;
import library.core.services.ClientService;
import library.core.session.Session;
import library.core.session.SessionContext;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

	private LoginManager loginManager;
	private SessionContext sessionContext;

	public LoginController(LoginManager loginManager, SessionContext sessionContext) {
		super();
		this.loginManager = loginManager;
		this.sessionContext = sessionContext;
	}

	public ResponseEntity<?> login(ClientType clientType, String email, String password) {
		ClientService clientService;
		try {
			clientService = this.loginManager.login(clientType, email, password);

		} catch (LibrarySystemException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sorry, can not log-in because" + "there was a problem while trying to log-in...");
		}
		if (clientService != null) {
			Session session = this.sessionContext.createSession();
			session.setAttributes("service", clientService);
			return ResponseEntity.ok(session.token);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry, 'EmailAddress' OR 'Password' are incorrect.");
	}

}
