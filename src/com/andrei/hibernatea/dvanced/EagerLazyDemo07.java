package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Student;


//Change fetch type in Instructor.java

public class EagerLazyDemo07 {
	
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
			
			//for retriving LAZY data after the session is closed
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			
			
			System.out.println("Andrei: Instructor: " + instructor);
			
			
		
			session.getTransaction().commit();
			
			 
			session.close();
			System.out.println("Andrei: The session is closed");
			
			
			System.out.println("Andrei: Courses: " + instructor.getCourses());
			
			
			System.out.println("Andrei: Done!");
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
