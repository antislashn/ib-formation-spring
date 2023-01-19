package org.antislashn.contacts.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.PostLoad;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ContactEntityListener {
		@Autowired private Validator validator;
		
		@PostLoad
		public void postLoad(Contact c) {
			log.info(">>> Contact : "+c);
			log.info(">>> validator : "+validator);
			var violations = validator.validate(c);
			violations.forEach(e->System.out.println(">>> "+e.getPropertyPath()+" - "+e.getMessage()));
			throw new ConstraintViolationException(violations);
		}
}
