package org.antislashn.communes.rest;

import java.util.List;
import java.util.Optional;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.repos.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commune-api")
public class CommunesRestController {
	@Autowired private CommuneRepository repo;
	private static int NB_ELEMENTS_PAR_PAGE = 10;

	@GetMapping("/commune/{id}")
	public ResponseEntity<?> findById(@PathVariable long id){
		Optional<Commune> opt = repo.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Commune>(opt.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Pas de communes avec l'id "+id,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/communes/cp/{cp}")
	public List<Commune> findByCodePostalStartingWith(@PathVariable String cp){
		return repo.findByCodePostalStartingWith(cp);
	}
	
	@GetMapping("/communes/cp1/{cp}")
	public List<Commune> findByCodePostal(@PathVariable String cp){
		Commune c = new Commune();
		c.setCodePostal(cp);
		Example<Commune> example = Example.of(c);
		return repo.findAll(example);
	}
	
	
	
	@GetMapping("/communes/dpt/{dpt}")
	public List<Commune> findByDepartementIgnoreCase(@PathVariable String dpt){
		return repo.findByDepartementIgnoreCase(dpt);
	}
	
	@GetMapping("/communes/nom/{nom}/{page}")
	public List<Commune> findByNomStartingWithIgnoreCase(@PathVariable String nom,@PathVariable  int page){
		Pageable p = PageRequest.of(page, NB_ELEMENTS_PAR_PAGE);
		return repo.findByNomStartingWithIgnoreCase(nom, p);
	}
	
}
