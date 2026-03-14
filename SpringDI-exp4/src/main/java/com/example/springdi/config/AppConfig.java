package com.example.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springdi.model.Student;

@Configuration
public class AppConfig {

@Bean
public Student student() {

Student s = new Student(102,"Rahul","Information Technology",2);

s.setCourse("Artificial Intelligence");
s.setYear(3);

return s;

}

}