package org.test.rest.spring.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "person" })
public class PersonController {
	private Logger logger = LoggerFactory.getLogger(PersonController.class);

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String get() {
		logger.debug("Page Get Start");
		return "person/index";
	}
}
