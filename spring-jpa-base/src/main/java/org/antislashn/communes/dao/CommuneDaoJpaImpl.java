package org.antislashn.communes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.communes.entities.Commune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommuneDaoJpaImpl implements CommuneDAO {
	@Autowired private EntityManagerFactory emf;

	@Override
	public Commune findById(int id) {
		Commune c = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		c = em.find(Commune.class, id);
		em.getTransaction().commit();
		em.close();
		return c;
	}

}
