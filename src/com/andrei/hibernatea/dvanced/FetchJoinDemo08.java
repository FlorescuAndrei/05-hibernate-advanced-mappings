package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;


//Change fetch type in Instructor.java

public class FetchJoinDemo08 {
	
	public static void main(String[] args) {
		
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
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Andrei: Instructor: " + instructor);
			
			//Work for Lazy and Eager. Call the getter method while the session is open
//			System.out.println("Andrei: Courses: " + instructor.getCourses());
			
		
			session.getTransaction().commit();
			
			//close the session for LAZY EAGER example. 
			session.close();
			System.out.println("Andrei: The session is closed");
			
			//This should fail for LAZY and work for EAGER
			System.out.println("Andrei: Courses: " + instructor.getCourses());
			
			
			System.out.println("Andrei: Done!");
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
