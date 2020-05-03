package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;


public class CreateCoursesForAnujDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); 
			Student student = session.get(Student.class, 1);
			
			System.out.println("student: " + student);
			
			System.out.println("Courses :" + student.getCourses());
			
			Course course1 = new Course("Rubik cube");
			Course course2 = new Course("Test Course");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit(); 
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
