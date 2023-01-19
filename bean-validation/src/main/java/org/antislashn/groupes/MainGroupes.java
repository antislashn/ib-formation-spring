package org.antislashn.groupes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.antislashn.validation.Personne;

public class MainGroupes {

	public static void main(String[] args) {
		SaiseParEtapes saisie = new SaiseParEtapes();
		
		saisie.setEtape1("étape 1");
		saisie.setEtape2("étape 2");
		
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<SaiseParEtapes>> violations = validator.validate(saisie,Step3.class);
		
		violations.forEach(c -> System.out.println(c.getMessage()));
	}

}
