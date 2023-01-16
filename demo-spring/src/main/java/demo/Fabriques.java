package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Fabriques {
	@Bean(name = "partition")
	public String foo() {
		return "Meunier tu dors";
	}
	
	@Bean
	public String bar() {
		return "bar tu dors";
	}
	
	@Bean
	public String marque() {
		return "Sony";
	}
}
