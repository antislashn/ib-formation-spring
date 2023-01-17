package org.antislashn.communes.services;

import java.util.Optional;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.repositories.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommuneService {
	@Autowired private CommuneRepository repo;
		
	public Commune findById(int id) {
		var opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
}
