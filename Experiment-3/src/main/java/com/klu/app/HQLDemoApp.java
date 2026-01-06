package com.klu.app;

import java.util.*;
import org.hibernate.*;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class HQLDemoApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1. Sort by price ASC
        session.createQuery("FROM Product p ORDER BY p.price ASC")
               .list().forEach(System.out::println);

        // 2. Sort by price DESC
        session.createQuery("FROM Product p ORDER BY p.price DESC")
               .list();

        // 3. Sort by quantity (highest first)
        session.createQuery("FROM Product p ORDER BY p.quantity DESC")
               .list();

        // 4. Pagination - first 3
        Query q1 = session.createQuery("FROM Product");
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        q1.list();

        // 5. Pagination - next 3
        Query q2 = session.createQuery("FROM Product");
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        q2.list();

        // 6a. Count total products
        Long total =
            (Long) session.createQuery("SELECT COUNT(p) FROM Product p")
                          .uniqueResult();

        // 6b. Count products where quantity > 0
        Long available =
            (Long) session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0")
                .uniqueResult();

        // 6c. Count grouped by description
        session.createQuery(
            "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
            .list();

        // 6d. Min & Max price
        Object[] price =
            (Object[]) session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p")
                .uniqueResult();

        // 7. WHERE price range
        session.createQuery(
            "FROM Product p WHERE p.price BETWEEN 1000 AND 10000")
            .list();

        // 8. LIKE queries
        session.createQuery("FROM Product p WHERE p.name LIKE 'L%'").list();
        session.createQuery("FROM Product p WHERE p.name LIKE '%p'").list();
        session.createQuery("FROM Product p WHERE p.name LIKE '%top%'").list();
        session.createQuery("FROM Product p WHERE LENGTH(p.name)=5").list();

        session.close();
        System.out.println("HQL operations executed successfully");
    }
}
