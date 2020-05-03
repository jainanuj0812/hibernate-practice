package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			
			Student student  = session.get(Student.class, id);
			student.setFirstName("Changesd");
			
			session.createQuery("update Student set email='anuj.jain@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	} 

}
