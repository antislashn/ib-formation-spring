package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource({"classpath:application.properties"})
public class MainDemoSpring {

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(MainDemoSpring.class);
		try(ctx){
			Musicien m1 = ctx.getBean(Musicien.class);
			Musicien m2 = ctx.getBean(Musicien.class);
			System.out.println(m1);
			System.out.println(m2);
		}
	}

}
