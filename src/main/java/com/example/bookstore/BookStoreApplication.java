package com.example.bookstore;

import com.example.bookstore.security.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	//@Bean
	CommandLineRunner commandLineRunner(IAccountService accountService)
	{
		return  args -> {
			accountService.addRole("USER");
			accountService.addRole("ADMIN");
			accountService.addUser("user", "123", "user@gmail.com");
			accountService.addUser("admin", "123", "admin@gmail.com");
			accountService.addroleToUser("user", "USER");
			accountService.addroleToUser("admin", "ADMIN");
			accountService.addroleToUser("admin", "USER");
		};

	};
}
