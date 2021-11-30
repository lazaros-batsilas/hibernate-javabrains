package com.javabrains.demo;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javabrains.demo.model.UserDetails;

@SpringBootTest
class HibernateJavabrainsApplicationTests {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	void contextLoads() {
	}
	
	@Test
	void saveUserDetails() {
		SessionFactory sessionFactory = 
					this.entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new UserDetails(1, "First user"));
		session.getTransaction().commit();
	}
	

}
