package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;

public class DeleteInstructorDetailDemo03 {

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
		
			//Delete for One to One Bidirectional ONLY instructionDetail
			
			session.beginTransaction();
			
			int id=3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("Deleting instructorDetail: " + instructorDetail);
			
			
			//!!!!!!!!!!!!!!!!!!!!!!
			//remove the associtated object reference
			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

}
