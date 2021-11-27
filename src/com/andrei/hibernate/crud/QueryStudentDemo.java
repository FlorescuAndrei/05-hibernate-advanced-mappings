package com.andrei.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andrei.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
		
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList(); 
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Florescu'").getResultList();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName='Daffy'").getResultList();
			displayStudents(students);
			
			
			students = session.createQuery("from Student s where s.email LIKE '%.com'").getResultList();
			displayStudents(students);
					
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}

}
