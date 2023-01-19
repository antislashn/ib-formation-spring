package org.antislashn.communes.repos;

import java.util.List;

import org.antislashn.communes.entities.Commune;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, Integer>, CustomCommuneRepo {
	List<Commune> findByCodePostalStartingWith(String codePostal);
	List<Commune> findByCodePostalStartingWith(String codePostal, Pageable page);
}
