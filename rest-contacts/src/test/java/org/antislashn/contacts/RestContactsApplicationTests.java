package org.antislashn.contacts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.antislashn.contacts.entities.Contact;
import org.antislashn.contacts.rest.ContactRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


class RestContactsApplicationTests extends AbstractRestServiceTest {
	@Autowired ContactRestController rest;
	
	@Test
	void contextLoads() {
		assertNotNull(rest);
	}
	
	@Test
	void testFindContactById() {
		Optional<Contact> opt = rest.findById(1);
		assertTrue(opt.isPresent());
	}
	
	@Test
	void testUriFindContactById() throws Exception {
		String uri ="/contacts-api/contact/id/1";
		MvcResult mvcResult = mock.
								perform(MockMvcRequestBuilders.get(uri)
										.accept(MediaType.APPLICATION_JSON_VALUE))
								.andReturn();
		assertEquals(200,mvcResult.getResponse().getStatus());
		String json = mvcResult.getResponse().getContentAsString();
		assertNotNull(json);
		assertFalse(json.isEmpty());
		Contact c = mapFromJson(json, Contact.class);
		assertNotNull(c);
	}

}
