package org.antislashn.communes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="communes")

	@NamedQuery(name="Commune.findByRegion",query = "SELECT c FROM Commune c WHERE UPPER(c.region) = UPPER(:region)")
	@NamedQuery(name="Commune.findByCodePostalStartingWith",query = "SELECT c FROM Commune c WHERE c.codePostal LIKE :cp")

public class Commune implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	@Column(name="code_postal")
	String codePostal;
	String departement;
	String region;
	double longitude;
	double latitude;

}
