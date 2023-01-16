package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Piano implements Instrument{
	private String marque;
	
	public Piano(String marque) {
		this.marque = marque;
	}
	@Override
	public void jouer() {
		System.out.println("CLANG CLANG CLANG "+marque);
		
	}

}
