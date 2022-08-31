package com.schedule.sheduletask.service;

import com.schedule.sheduletask.dto.PersonDto;
import com.schedule.sheduletask.model.Person;
import com.schedule.sheduletask.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepo;
    @Override
    public ResponseEntity<Person> createPerson(PersonDto pdto) {
        Person p = Person.builder()
                .name(pdto.getName())
                .username(pdto.getUsername())
                .build();
        log.info("Person with name {} created", pdto.getName());
        return ResponseEntity.ok().body(personRepo.save(p));
    }

    @Override
    public ResponseEntity<List<Person>> fetchAllPerson() {
        log.info("All names return");
        return ResponseEntity.ok().body(personRepo.findAll());
    }

    @Scheduled(fixedDelay = 5000L)
    void cronJob(){
        List<Person> people = personRepo.findAll();
        log.info("these are registered persons in the db {}",people);
    }
}
