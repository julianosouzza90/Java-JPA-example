package com.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int quantity;

  @ManyToOne
  private Order order;

  @ManyToOne
  private Product product;
  
  
  public OrderItem(){}
  public OrderItem(int quantity, Order order, Product product){
    this.quantity = quantity;
    this.order = order;
    this.product = product;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public String getProductName() {
    return this.product.getName();
  }
  public BigDecimal getTotalPrice() {
      return this.order.getPrice()
      .multiply(new BigDecimal(this.quantity));
  }

}
