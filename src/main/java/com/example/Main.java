package com.example;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.dao.CategoryDao;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.model.Category;
import com.model.Client;
import com.model.Order;
import com.model.OrderItem;
import com.model.Product;
import com.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(em);
        OrderDao orderDao = new OrderDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        Category category = new Category("Eletrônicos");
        Product product = new Product("Computador", "Computador de última geração", new BigDecimal("1800"),category);
        Product product2 = new Product("Computador 2", "Computador de última geração 2", new BigDecimal("1700"),category);
        Client client = new Client("Juliano");
        Order order = new Order();
        
        em.getTransaction().begin();

        categoryDao.create(category);
        productDao.create(product);

        order.addItem(new OrderItem(10, order, product));
        order.addItem(new OrderItem(10, order, product2));
        orderDao.create(order);



       /*  List<Product> products = productDao.listAll();
        products.forEach(p -> System.out.println(p));*/

        List<OrderItem> orderItem = orderDao.listAll();
        orderItem.forEach(o -> System.out.println("-->" + o.getProductName()));

        System.out.println("Finished");

    
        em.close();
    }
}