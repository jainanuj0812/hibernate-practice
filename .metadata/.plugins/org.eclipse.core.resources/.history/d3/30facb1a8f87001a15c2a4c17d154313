package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			
			Student student  = session.get(Student.class, id);
			session.delete(student);
			
			session.createQuery("delete from Student s where s.lastName='test'").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	} 

}
