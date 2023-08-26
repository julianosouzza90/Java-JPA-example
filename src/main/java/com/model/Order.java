package com.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  private BigDecimal amount;
  private LocalDate date = LocalDate.now();


  @ManyToOne
  private Client client;
  
  @OneToMany(mappedBy = "order", cascade =  CascadeType.ALL)
  private List<OrderItem> items = new ArrayList<OrderItem>();

  public Order() {}
  public Order(Client client){
    this.client = client;
  }


  public void addItem(OrderItem orderItem){
    orderItem.setOrder(this);
    this.items.add(orderItem);
  }
  public BigDecimal getPrice() {
    return this.amount;
  }

}
