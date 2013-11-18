package org.test.rest.spring.controller.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.test.rest.spring.domain.Person;
import org.test.rest.spring.jaxb.Persons;
import org.test.rest.spring.services.PersonService;

@Controller
@RequestMapping("person")
public class PersonRESTController {
	private Logger logger = LoggerFactory.getLogger(PersonRESTController.class);
	@Autowired
	private PersonService service;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public	Persons list() {
		return new Persons(service.list());
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = { "application/xml" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Persons listXML() {
		return new Persons(service.list());
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Person get(@PathVariable Long id) {
		return service.get(id);
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Person p) {
		Long id = service.add(p);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody Person p) {
		service.update(p);
	}

}
