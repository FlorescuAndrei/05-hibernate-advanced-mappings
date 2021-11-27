package com.andrei.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int id = 2;
			
			session.beginTransaction();
			
			
			Student myStudent = session.get(Student.class, id);
			
			System.out.println("Get complete: " + myStudent );
			
			
			myStudent.setFirstName("Scooby");
			
			System.out.println("Update complete: " + myStudent );
			
			
			session.getTransaction().commit();
			
			
			//Update with Query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Update all emails");
			session.createQuery("update Student set email='foo.gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
