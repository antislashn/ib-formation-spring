package org.antislashn.communes.repos;

import javax.persistence.EntityManager;

import org.antislashn.communes.entities.Commune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CustomCommuneRepoImpl implements CustomCommuneRepo {
	@Autowired EntityManager em;
	
	@Override
	@Transactional
	public Commune trouverParId(int id) {
		return em.find(Commune.class, id);
	}

}
