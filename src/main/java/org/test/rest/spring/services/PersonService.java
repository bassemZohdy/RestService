package org.test.rest.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.rest.spring.domain.Person;
import org.test.rest.spring.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo repo;

	public List<Person> list() {
		return repo.findAll();
	}

	public Person get(Long id) {
		return repo.findOne(id);
	}

	public Long add(Person p) {
		repo.saveAndFlush(p);
		return p.getId();
	}

	public void update(Person p) {
		repo.saveAndFlush(p);
	}

	public void delete(Long id) {
		repo.delete(id);
	}

}
