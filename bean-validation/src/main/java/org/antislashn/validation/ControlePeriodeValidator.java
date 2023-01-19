package org.antislashn.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ControlePeriodeValidator implements ConstraintValidator<ControlePeriode, DateVoyage>{

	@Override
	public boolean isValid(DateVoyage dv, ConstraintValidatorContext context) {
		return dv.getRetour().isAfter(dv.getDepart());
	}
	
}