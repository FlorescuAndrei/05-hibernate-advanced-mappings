package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;

public class DeleteCourseDemo09 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id=10;
			Course course = session.get(Course.class, id);
			
			System.out.println("Deleting course: " + course);
			
			session.delete(course);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

}
