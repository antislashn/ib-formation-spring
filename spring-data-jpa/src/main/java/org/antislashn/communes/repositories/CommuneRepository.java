package org.antislashn.communes.repositories;

import java.util.List;

import org.antislashn.communes.entities.Commune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


public interface CommuneRepository extends HideMehodRepo<Commune, Integer>{
	List<Commune> findCommuneByCodePostalStartingWith(String cp);
}
