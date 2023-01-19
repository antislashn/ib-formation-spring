package org.antislashn.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "contacts")
@ResponseBody
public class Contacts implements Serializable{
	@JacksonXmlProperty(localName = "contact")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Contact> contacts = new ArrayList<>();
	
	public Contacts() {}
	
	

	public Contacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
