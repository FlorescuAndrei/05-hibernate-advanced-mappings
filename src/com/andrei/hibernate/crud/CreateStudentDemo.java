package com.andrei.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Andrei", "Florescu", "andrei@email.com");
			Student student1 = new Student("John", "Doe", "john@email.com");
			Student student2 = new Student("Mary", "Public", "mary@email.com");
			Student student3 = new Student("Bonita", "Applebum", "bonita@email.com");
			
			session.beginTransaction();
			
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

}
