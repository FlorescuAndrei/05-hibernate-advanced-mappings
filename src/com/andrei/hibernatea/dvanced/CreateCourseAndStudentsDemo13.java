package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Review;
import com.andrei.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo13 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course course = new Course("Tennis techniques");
			System.out.println("Saving the course: " + course);
			session.save(course);
			
			
			Student student1 = new Student("John", "Doe", "john@email");
			Student student2 = new Student("Mary", "Public", "mary@email");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			System.out.println("\nSaving students...");
			session.save(student1);
			session.save(student2);
			
			System.out.println("Save Students: " + course.getStudents());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
