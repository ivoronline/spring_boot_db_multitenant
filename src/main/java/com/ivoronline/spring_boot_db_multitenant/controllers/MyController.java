package com.ivoronline.spring_boot_db_multitenant.controllers;

import com.ivoronline.spring_boot_db_multitenant.entities.Person;
import com.ivoronline.spring_boot_db_multitenant.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@	RestController
public class MyController {

  //PROPERTIES
  @Autowired PersonRepository personRepository;

  //================================================================
  // ADD PERSON
  //================================================================
  @RequestMapping("AddPerson")
  String addPerson() throws SQLException {

    //CREATE ENTITY OBJECT
    Person personEntity      = new Person();
                  personEntity.name = "John";
                  personEntity.age  = 20;

    //STORE ENTITY OBJECT INTO DB
    personRepository.save(personEntity);

    //RETURN SOMETHING TO BROWSER
    return personEntity.name + " was stored into DB";

  }

}
