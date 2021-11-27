package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;

public class CreateInstructorDemo01 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Andrei", "Florescu", "andrei@luv2code.com");
			
			InstructorDetail isntructorDetail= new InstructorDetail("youtube.com", "Java");
			
			instructor.setInstructorDetail(isntructorDetail);
			
			
			session.beginTransaction();
			
			// also save the details object (CascadeType.All)
			session.save(instructor);
			
			System.out.println("Saving instructor and instructorDetail: " + instructor );
			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
