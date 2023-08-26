package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
  // Cria uma instância da EntityManagerFactory com base na unidade de persistência definida no persistence.xml.

    private static final EntityManagerFactory FACTORY = 
    Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
      return FACTORY.createEntityManager();
    }
  
}
