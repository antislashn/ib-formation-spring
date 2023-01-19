package org.antislashn.validation;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@PassengerCount
public class Bus {
	@NotNull
	private String constructeur;
	
	@NotNull
	@Size(min=6, max=14)
	private String immatriculation;
	
	@Max(7)
	private int nbPlaces;
	
	private List<Personne> passagers;
}
