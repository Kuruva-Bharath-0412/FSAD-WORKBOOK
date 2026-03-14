package com.example.springdi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springdi.model.Student;

public class XMLMain {

public static void main(String[] args) {

ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");

Student s = (Student) context.getBean("student");

s.display();

}

}