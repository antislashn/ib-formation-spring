package demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Guitare implements Instrument{

	@Override
	public void jouer() {
		System.out.println("cling cling cling");
		
	}

}
