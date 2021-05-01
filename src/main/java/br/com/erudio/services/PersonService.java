package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person FindById(String id) {
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setName("andre");
		person.setLastName("ramos");
		person.setAddress("SP");
		person.setGender("Male");
		return person;
		
		
		
	}

}
