package org.test.rest.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.rest.spring.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	
}
