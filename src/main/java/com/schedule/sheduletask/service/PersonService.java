package com.schedule.sheduletask.service;

import com.schedule.sheduletask.dto.PersonDto;
import com.schedule.sheduletask.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    ResponseEntity<Person> createPerson(PersonDto pdto);
    ResponseEntity<List<Person>> fetchAllPerson();
}
