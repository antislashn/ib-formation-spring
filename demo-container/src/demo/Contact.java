package demo;

import container.Auto;
import container.Composant;

@Composant
public class Contact {
	@Auto private Adresse adresse;
		
	public void sayHello() {
		System.out.println("Région : "+adresse.getRegion());
	}
}
