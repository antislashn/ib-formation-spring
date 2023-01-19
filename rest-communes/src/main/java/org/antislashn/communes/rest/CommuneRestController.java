package org.antislashn.communes.rest;

import java.util.List;
import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.repos.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communes-api")
public class CommuneRestController {
	@Autowired private CommuneRepository repo;
	private static int PAGE_SIZE=20;
	
	@GetMapping("/exemple")
	public List<Commune> exemple(){
		Commune c = new Commune();
		c.setCodePostal("22400");
		Example<Commune> ex = Example.of(c);
		return repo.findAll(ex)
;	}

	@GetMapping("/communes/code-postal/{cp}")
	public List<Commune> findByCodePostalStartingWith(@PathVariable(name="cp") String cp){
		return repo.findByCodePostalStartingWith(cp);
	}
	
	@GetMapping("/communes/cp/{cp}")
	public List<Commune> findByCodePostalStartingWith(@PathVariable(name="cp") String cp,
													@RequestParam(defaultValue = "0", name="p") int numPage ){
		Sort sort = Sort.by("codePostal","nom");
		Pageable page = PageRequest.of(numPage, PAGE_SIZE,sort);
		return repo.findByCodePostalStartingWith(cp,page);
	}
	
	@GetMapping("/commune/id/{id}")
	public Commune findById(@PathVariable int id) throws Exception {
		return repo.findById(id)
					.orElseThrow(()->new Exception("pas de commune pour id "+id));
	}
	
	@GetMapping("/test/{id}")
	public Commune trouver(@PathVariable int id) {
		return repo.trouverParId(id);
	}
}
