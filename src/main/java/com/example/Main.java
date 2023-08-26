package com.example;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.dao.ProductDao;
import com.model.Product;
import com.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);

        em.getTransaction().begin();
        
        Product product = new Product("Computador", "Computador de última geração", new BigDecimal("1800"));
    
        productDao.create(product);
        List<Product> products = productDao.listAll();
        products.forEach(p -> System.out.println(p));

    }
}