package org.antislashn.communes;


import org.antislashn.communes.services.CommuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringDataJpa {

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		try(ctx){
			var service = ctx.getBean(CommuneService.class);
			var c = service.findById(32165);
			System.out.println(c);
		}
	}

}
;