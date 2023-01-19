package org.antislashn.communes.rest;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.repos.CommuneReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCommuneController {
	@Autowired CommuneReadRepository repo;
	
	
	@GetMapping("/{id}")
	public Commune findById(@PathVariable int id) throws Exception {
		return repo.findById(id).orElseThrow(Exception::new);
	}
}
