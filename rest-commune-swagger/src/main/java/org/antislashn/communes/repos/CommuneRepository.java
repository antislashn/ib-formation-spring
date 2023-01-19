package org.antislashn.communes.repos;

import java.util.List;

import org.antislashn.communes.entities.Commune;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, Long>{
	List<Commune> findByCodePostalStartingWith(String cp);
	List<Commune> findByDepartementIgnoreCase(String departement);
	List<Commune> findByNomStartingWithIgnoreCase(String nom,Pageable page);
}
