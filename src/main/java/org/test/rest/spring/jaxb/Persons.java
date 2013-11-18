package org.test.rest.spring.jaxb;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.test.rest.spring.domain.Person;

@XmlRootElement
public class Persons {
	@XmlElement(name="person", type = Person.class)
	private List<Person> persons = new ArrayList<Person>();

	public Persons() {
	}

	public Persons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setBooks(List<Person> persons) {
		this.persons = persons;
	}
}
