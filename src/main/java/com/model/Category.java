package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
  
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private long id;

  private String name;

  public Category(){}
  public Category(String name) {
    this.name = name;
  }


  
  

}
