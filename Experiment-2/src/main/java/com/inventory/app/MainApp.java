package com.inventory.app;

import java.util.Scanner;
import org.hibernate.*;
import com.inventory.model.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

    static SessionFactory factory = HibernateUtil.getSessionFactory();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n==== PRODUCT MENU ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: insertProduct(); break;
                case 2: viewProduct(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: System.out.println("Thank You"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }

    // INSERT
    static void insertProduct() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product();
        sc.nextLine();
        System.out.print("Name: ");
        p.setName(sc.nextLine());
        System.out.print("Description: ");
        p.setDescription(sc.nextLine());
        System.out.print("Price: ");
        p.setPrice(sc.nextDouble());
        System.out.print("Quantity: ");
        p.setQuantity(sc.nextInt());

        session.save(p);
        tx.commit();
        session.close();

        System.out.println("Product Added Successfully");
    }

    // SELECT
    static void viewProduct() {
        Session session = factory.openSession();
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);
        if (p != null) {
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
        } else {
            System.out.println("Product Not Found");
        }
        session.close();
    }

    // UPDATE
    static void updateProduct() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);
        if (p != null) {
            System.out.print("New Price: ");
            p.setPrice(sc.nextDouble());
            System.out.print("New Quantity: ");
            p.setQuantity(sc.nextInt());
            session.update(p);
            tx.commit();
            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
        session.close();
    }

    // DELETE
    static void deleteProduct() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);
        if (p != null) {
            session.delete(p);
            tx.commit();
            System.out.println("Product Deleted");
        } else {
            System.out.println("Product Not Found");
        }
        session.close();
    }
}
