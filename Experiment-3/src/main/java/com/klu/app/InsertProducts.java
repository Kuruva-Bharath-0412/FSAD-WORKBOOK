package com.klu.app;

import org.hibernate.*;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class InsertProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 5));
        session.save(new Product("Mouse", "Electronics", 500, 20));
        session.save(new Product("Keyboard", "Electronics", 1500, 15));
        session.save(new Product("Chair", "Furniture", 3000, 10));
        session.save(new Product("Table", "Furniture", 7000, 3));
        session.save(new Product("Bottle", "Kitchen", 800, 25));

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }
}
