package com.mytodos.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BCryptEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i<=10; i++) {
		
			String encoded = encoder.encode("meet123");
			System.out.println(encoded);
		}
		
		
	}

}
