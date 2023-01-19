package org.antislashn.validation.age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeMinValidator implements ConstraintValidator<AgeMin, Integer> {
	
	private int minAge;
	
	@Override
	public void initialize(AgeMin age) {
		minAge = age.value();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value==null) {
			return true;
		}
		return value>=minAge;
	}

}
