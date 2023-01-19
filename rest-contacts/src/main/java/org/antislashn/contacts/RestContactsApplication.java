package org.antislashn.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RestContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestContactsApplication.class, args);
	}

}
