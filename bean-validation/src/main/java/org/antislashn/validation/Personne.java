package org.antislashn.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.antislashn.validation.age.AgeMin;
public class Personne {
	@NotNull
	@Size(min=1,max=3)
	private String civilite;
	@NotNull
	@Size(max=50)
	private String prenom;
	@NotNull()
	@Size(max=50)
	private String nom;
	//@Max(value=130,message="l'âge ne doit pas être supérieur à 130 ans")
	@AgeMin(18)
	private int age;
	
	public Personne(String civilite, String prenom, String nom) {
		super();
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Personne(String civilite, String prenom, String nom, int age) {
		super();
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
