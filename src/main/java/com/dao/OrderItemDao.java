package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.OrderItem;

public class OrderItemDao {

  private EntityManager em;

  public OrderItemDao(EntityManager em) {
    this.em = em;
  }


  public List<OrderItem> getOrders() {
    String jpql = "SELECT o FROM OrderItem o";

    return this.em.createQuery(jpql, OrderItem.class)
    .getResultList();
  }
  
}
