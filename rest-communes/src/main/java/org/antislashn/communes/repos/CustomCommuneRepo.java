package org.antislashn.communes.repos;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.antislashn.communes.entities.Commune;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomCommuneRepo {

	Commune trouverParId(int id);
}
