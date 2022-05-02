package com.andrei.hibernatea.dvanced;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Course;
import com.andrei.hibernate.entity.Instructor;
import com.andrei.hibernate.entity.InstructorDetail;
import com.andrei.hibernate.entity.Review;
import com.andrei.hibernate.entity.Student;

public class CreateCourseAndReviewDemo10 {

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
			
			course.addReview(new Review("Gerat course ....love it!"));
			course.addReview(new Review("Cool course ....job well done!"));
			course.addReview(new Review("What a dumb course!...."));
			
			System.out.println("Saving the course: ");
			System.out.println(course);
			System.out.println("And the reviews: ");
			System.out.println(course.getReviews());
			session.save(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
