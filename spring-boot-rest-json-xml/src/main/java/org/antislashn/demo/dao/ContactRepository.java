package org.antislashn.demo.dao;

import java.util.List;

import org.antislashn.demo.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	List<Contact> findContactsByNomStartingWith(String nom);
	List<Contact> findContactsByCivilite(String civilite);

}
