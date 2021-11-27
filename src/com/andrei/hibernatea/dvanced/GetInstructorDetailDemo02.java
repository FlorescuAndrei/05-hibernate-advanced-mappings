package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;

//One to One Bidirectional 

public class GetInstructorDetailDemo02 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			

			session.beginTransaction();
			
			int id = 1;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			
			System.out.println("instructorDetail: " + instructorDetail);
			
			System.out.println("associated instructor: " +  instructorDetail.getInstructor());
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			session.close();
			factory.close();
		}

	}

}
