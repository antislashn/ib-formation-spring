package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Spectateurs {
	
	@Before("execution(* *.Musicien.jouer(..))")
	public void prendrePlace() {
		System.out.println(">>> Tout le monde éteind son téléphone");
	}
	
	@After("execution(* *.Musicien.jouer(..))")
	public void applaudir() {
		System.out.println(">>> CLAP CLAP CLAP");
	}
	
}
