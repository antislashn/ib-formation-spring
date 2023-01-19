package org.antislashn.validation;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MainControlePeriode {

	public static void main(String[] args) {
		DateVoyage dv = new DateVoyage();
		dv.setDepart(LocalDate.now());
		dv.setRetour(LocalDate.of(2021, 2, 2));
		

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		//Set<ConstraintViolation<DateVoyage>> violations = validator.validate(dv);
		var violations = validator.validate(dv);
		violations.forEach(c -> System.out.println(c.getMessage()));
	}
}
