package org.antislashn.communes.repositories;

import org.antislashn.communes.entities.Commune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends CrudRepository<Commune, Integer>{

}
