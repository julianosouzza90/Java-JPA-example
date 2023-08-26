package com.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.model.Product;

public class ProductDao {
  
  private EntityManager em;

  public ProductDao(EntityManager em) {
    this.em = em;
  }

  public void create(Product product) {
    this.em.persist(product);
  }

  public List<Product>  listAll() {
    String jpql = "SELECT p FROM Product p";
    return this.em.createQuery(jpql,Product.class)
    .getResultList();
  }
    
}
