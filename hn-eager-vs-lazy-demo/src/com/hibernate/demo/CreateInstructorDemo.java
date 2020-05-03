package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); 
			
			Instructor instructor = new Instructor("Anuj", "Jain", "anuj.jain@test.com");
			InstructorDetail instructorDetail = new InstructorDetail("Test Channel", "coding");
			
			instructor.setInstructorDetail(instructorDetail);
	
			session.save(instructor);
			 
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}