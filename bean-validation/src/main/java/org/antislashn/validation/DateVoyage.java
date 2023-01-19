package org.antislashn.validation;

import java.time.LocalDate;

@ControlePeriode
public class DateVoyage {
	private LocalDate depart;
	private LocalDate retour;
	public LocalDate getDepart() {
		return depart;
	}
	public void setDepart(LocalDate depart) {
		this.depart = depart;
	}
	public LocalDate getRetour() {
		return retour;
	}
	public void setRetour(LocalDate retour) {
		this.retour = retour;
	}

}
