package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Atul", "Saxena", "john.doe@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("ID: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println(myStudent);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
