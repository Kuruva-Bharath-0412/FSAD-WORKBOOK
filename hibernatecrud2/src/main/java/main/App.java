package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Product;
import util.HibernateUtil;

public class App {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

Product p1 = new Product("Laptop","Gaming Laptop",85000,5);
Product p2 = new Product("Mouse","Wireless Mouse",1200,20);

session.save(p1);
session.save(p2);

tx.commit();

System.out.println("Products inserted successfully");

session.close();

}

}