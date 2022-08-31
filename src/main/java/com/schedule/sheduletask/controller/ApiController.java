package com.schedule.sheduletask.controller;

import com.schedule.sheduletask.dto.PersonDto;
import com.schedule.sheduletask.model.Person;
import com.schedule.sheduletask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final PersonService personService;

    @PostMapping("/persons")
    public ResponseEntity<Person> create(@RequestBody PersonDto pdto){
        return personService.createPerson(pdto);
    }
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> fetchPersons(){
        return personService.fetchAllPerson();
    }
}
