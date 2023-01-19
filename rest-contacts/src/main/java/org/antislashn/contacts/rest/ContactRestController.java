package org.antislashn.contacts.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.antislashn.contacts.entities.Adresse;
import org.antislashn.contacts.entities.Contact;
import org.antislashn.contacts.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/contacts-api")
public class ContactRestController {
	@Autowired private ContactRepository repo;
	
	
	@GetMapping("/contact/id/{id}")
	public Optional<Contact> findById(@PathVariable long id){
		return repo.findById(id);
	}

	@GetMapping("/contacts/pays/{pays}")
	public List<Contact> findContactByPays(@PathVariable String pays){
		return repo.findDistinctByAdressesPaysIgnoreCase(pays);
	}
	
	@DeleteMapping("/contact/id/{id}")
	public void delete(@PathVariable long id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/contact/adresses/{id}")
	public List<Adresse> findAdresseByContactId(@PathVariable(name="id") long contactId){
		List<Adresse> adresses = new ArrayList<>();
		Optional<Contact> opt = repo.findById(contactId);
		if(opt.isPresent()) {
			return opt.get().getAdresses();
		}
		return adresses;
	}
	
	//@RequestMapping(path = "/contact/save",method = {RequestMethod.POST,RequestMethod.PUT})
	@PostMapping("/contact/save")
	public Contact save(@RequestBody Contact contact) {
		return repo.save(contact);
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleException(ConstraintViolationException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getConstraintViolations().forEach(e->errors.put(e.getPropertyPath().toString(),e.getMessage()));
		return errors;
	}
	
}
