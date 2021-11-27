package com.andrei.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			
//			Student student = session.get(Student.class, id);
//			
//			System.out.println("Deleting student " + student);
//			session.delete(student);
//			
			session.getTransaction().commit();
			
			//Use Query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

}
