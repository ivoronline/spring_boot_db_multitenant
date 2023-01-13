package com.ivoronline.spring_boot_db_multitenant.repositories;

import com.ivoronline.spring_boot_db_multitenant.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> { }
