package org.antislashn.demo.service;

import org.antislashn.demo.dao.ContactRepository;
import org.antislashn.demo.domain.Contact;
import org.antislashn.demo.domain.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactServiceRest {
	
	@Autowired private ContactRepository repo;
	
	@GetMapping(path = "/contact/{id}",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Contact getContactById(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	
	@GetMapping(path = "/contacts/all",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Contacts findAllContacts(){
		return new Contacts(repo.findAll());
	}
	
	@GetMapping(path = "/contacts/civilite/{civilite}",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Contacts fincContactsByCivilite(@PathVariable String civilite){
		return new Contacts(repo.findContactsByCivilite(civilite));
	}
	
	@PostMapping(path = "/contact/new",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Contact newContact(@RequestBody Contact contact) {
		return repo.save(contact);
	}
	
	

}
