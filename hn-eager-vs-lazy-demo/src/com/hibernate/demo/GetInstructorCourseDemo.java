package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;


public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); 
			
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("Instructor " + instructor);
			
			System.out.println("Courses: "+ instructor.getCourse());
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
