package org.antislashn.contacts.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name="personnes")
@EntityListeners(ContactEntityListener.class)
public class Contact implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private Long id;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@NotBlank @Size(min=1, max=10)
	private String nom;
	private String prenom;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="contacts_adresses",
		joinColumns=@JoinColumn(name="fk_personne"),
		inverseJoinColumns = @JoinColumn(name="fk_adresse"))
	@JsonIgnore
	private List<Adresse> adresses;
	
	public void add(Adresse adresse) {
		adresses.add(adresse);
	}
	
	public Contact(Civilite civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
}