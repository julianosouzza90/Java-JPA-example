package com.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;

  private LocalDate created_at;



  private Category category;
  
  public Product(){}

  public Product(String name, String description, BigDecimal price){ 
    this.name = name;
    this.description = description;
    this.price = price;
    this.created_at = LocalDate.now();
  }

  public void listAll() {
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    return "Produto: " + this.name + "\n Descrição: " +
     this.description +  "\n Valor: " + decimalFormat.format(this.price);
    
  }
}
