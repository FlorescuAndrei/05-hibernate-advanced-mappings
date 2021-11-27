package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;

public class DeleteInstructorDemo04 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Forun instructor: " + instructor);
			
			if(instructor != null) {
				System.out.println("Delete instructor");
				
				//also delete details (CascadeType.All)
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

}
