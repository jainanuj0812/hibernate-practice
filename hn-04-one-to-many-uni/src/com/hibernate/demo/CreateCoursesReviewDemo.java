package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;


public class CreateCoursesReviewDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); 
			
			Course course = new Course("Javascript");
			
			Review review1 = new Review("Test review 1");
			Review review2 = new Review("Test review 2");
			
			course.addReview(review1);
			course.addReview(review2);
			
			session.save(course);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}