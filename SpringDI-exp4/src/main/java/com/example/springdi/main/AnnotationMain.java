package com.example.springdi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springdi.config.AppConfig;
import com.example.springdi.model.Student;

public class AnnotationMain {

public static void main(String[] args) {

ApplicationContext context =
new AnnotationConfigApplicationContext(AppConfig.class);

Student s = context.getBean(Student.class);

s.display();

}

}