package org.antislashn.contacts.repos;

import java.util.List;

import org.antislashn.contacts.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	List<Contact> findDistinctByAdressesPaysIgnoreCase(String pays);
}
