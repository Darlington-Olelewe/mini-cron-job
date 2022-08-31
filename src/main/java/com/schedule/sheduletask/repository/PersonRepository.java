package com.schedule.sheduletask.repository;

import com.schedule.sheduletask.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
