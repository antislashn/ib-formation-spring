package org.antislashn.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy= {ControlePeriodeValidator.class})
public @interface ControlePeriode {
	String message() default "La date de retour doit postérieure à la date de départ";
	Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };	
}
