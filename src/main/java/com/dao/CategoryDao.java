package com.dao;

import javax.persistence.EntityManager;
import com.model.Category;

public class CategoryDao {
  
  private EntityManager em;

  public  CategoryDao(EntityManager em) {
    this.em = em;
  }

  public void create(Category category) {
    this.em.persist(category);
  }
}
