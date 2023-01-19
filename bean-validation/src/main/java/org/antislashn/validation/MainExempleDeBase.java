package org.antislashn.validation;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MainExempleDeBase {

	public static void main(String[] args) {
		Personne p1 = new Personne("M", "Gaston", "LAGAFFE",15);
		Personne p2 = null;
		
	
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Personne>> violations = validator.validate(p1);
		
		violations.forEach(c -> System.out.println(c.getMessage()));

	}

}
