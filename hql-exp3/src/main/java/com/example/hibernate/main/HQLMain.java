package com.example.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.hibernate.model.Product;
import com.example.hibernate.util.HibernateUtil;

public class HQLMain {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

/* Insert sample products */

session.save(new Product("Laptop","Electronics",55000,5));
session.save(new Product("Mobile","Electronics",20000,10));
session.save(new Product("Mouse","Accessories",500,25));
session.save(new Product("Keyboard","Accessories",1200,15));
session.save(new Product("Headphones","Electronics",2500,8));
session.save(new Product("Monitor","Electronics",12000,6));

tx.commit();

/* Sorting by price ASC */

Query<Product> q1 =
session.createQuery("from Product p order by p.price asc",Product.class);

List<Product> list1=q1.list();

System.out.println("Price ASC");

for(Product p:list1){
System.out.println(p.getName()+" "+p.getPrice());
}

/* Sorting by price DESC */

Query<Product> q2 =
session.createQuery("from Product p order by p.price desc",Product.class);

List<Product> list2=q2.list();

System.out.println("Price DESC");

for(Product p:list2){
System.out.println(p.getName()+" "+p.getPrice());
}

/* Pagination */

Query<Product> q3=session.createQuery("from Product",Product.class);

q3.setFirstResult(0);
q3.setMaxResults(3);

List<Product> list3=q3.list();

System.out.println("First 3 Products");

for(Product p:list3){
System.out.println(p.getName());
}

/* Aggregate count */

Query<Long> q4=session.createQuery("select count(*) from Product",Long.class);

Long count=q4.uniqueResult();

System.out.println("Total Products = "+count);

session.close();

}

}