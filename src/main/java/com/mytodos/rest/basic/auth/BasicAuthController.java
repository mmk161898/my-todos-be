package com.mytodos.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BasicAuthController {
	
	@GetMapping(path = "/basic-auth")
	public AuthenticationBean basicAuthBean() {
		return new AuthenticationBean("You are authenticated.");
//		throw new RuntimeException("Some Error Has occurred. Kindly contact your administration.");
	}
}
