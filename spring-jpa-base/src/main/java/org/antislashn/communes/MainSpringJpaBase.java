package org.antislashn.communes;

import java.util.List;

import org.antislashn.communes.dao.CommuneDAO;
import org.antislashn.communes.entities.Commune;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringJpaBase {

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		try(ctx){
			CommuneDAO dao = ctx.getBean(CommuneDAO.class);
			Commune c = dao.findById(654);
			System.out.println(c);
		}
	}

}
