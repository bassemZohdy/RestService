package org.test.rest.spring.test.integration;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.test.rest.spring.domain.Person;
import org.test.rest.spring.jaxb.Persons;

public class RESTTest {

	private String uri = "http://localhost:8000/RestService/rest/person";
	private RestTemplate template = new RestTemplate();

	@Test()
	public void postTest() {
		Person p = new Person();
		p.setName("name");
		p.setFamilyName("familyName");
		template.postForEntity(uri, p, null);
	}

	@Test
	public void listTest() {
		Persons ps = template.getForObject(uri, Persons.class);
		for (Person p : ps.getPersons()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>Name "
					+ p.getName());
		}
	}
}
