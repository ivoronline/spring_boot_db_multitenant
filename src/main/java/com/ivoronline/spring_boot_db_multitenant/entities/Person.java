package com.ivoronline.spring_boot_db_multitenant.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.TenantId;

@Entity
public class Person {

  //PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

}
