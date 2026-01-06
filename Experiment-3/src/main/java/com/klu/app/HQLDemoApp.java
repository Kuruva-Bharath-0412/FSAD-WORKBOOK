package com.klu.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class HQLDemoApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Sort by price ASC
        List<Product> list1 =
                session.createQuery("FROM Product p ORDER BY p.price ASC").list();
        list1.forEach(System.out::println);

        // Sort by quantity DESC
        session.createQuery("FROM Product p ORDER BY p.quantity DESC").list();

        // Pagination
        Query q = session.createQuery("FROM Product");
        q.setFirstResult(0);
        q.setMaxResults(3);
        q.list();

        session.close();
        System.out.println("HQL executed successfully");
    }
}
