package org.antislashn.validation;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Association {
	@NotNull @Valid	private Personne president;
	
	@Valid private Personne tresorier;
	
	@Valid private Personne secretaire;
	
	@Valid List<Personne> membres;
}
