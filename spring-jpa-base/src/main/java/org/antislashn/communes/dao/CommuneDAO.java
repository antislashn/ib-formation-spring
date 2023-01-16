package org.antislashn.communes.dao;

import org.antislashn.communes.entities.Commune;


public interface CommuneDAO {
	Commune findById(int id);
}
