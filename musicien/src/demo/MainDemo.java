package demo;

public class MainDemo {

	public static void main(String[] args) {
		// instanciation des classes
		Instrument instrument = new Guitare();
		Musicien musicien = new Musicien();
		
		// association des instances
		musicien.setInstrument(instrument);
		musicien.setPartition("Au clair de la lune");
		
		// code métier
		musicien.jouer();
	}

}
