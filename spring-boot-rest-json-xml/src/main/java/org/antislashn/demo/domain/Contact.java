package org.antislashn.demo.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"civilite","nom","prenom"})
@Entity
@Table(name="personnes")
@Access(AccessType.FIELD)
@JacksonXmlRootElement(localName = "contact")
@ResponseBody
public class Contact implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk")
	@JacksonXmlProperty(isAttribute = true,localName = "pk")
	private Long id;
	private String civilite;
	private String nom;
	private String prenom;

}
