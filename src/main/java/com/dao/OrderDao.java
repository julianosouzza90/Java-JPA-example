package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.Order;
import com.model.OrderItem;

public class OrderDao {
  
  private EntityManager em;

  public OrderDao(EntityManager em) {
    this.em = em;
  }


  public void create(Order order) {
      order = em.merge(order);
      this.em.persist(order);
  }

  public List<OrderItem> listAll() {
    String jpql = "SELECT o FROM OrderItem o";
    return this.em.createQuery(jpql).getResultList();
  }

 
}
