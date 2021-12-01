package com.javabrains.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javabrains.demo.model.Address;
import com.javabrains.demo.model.UserDetails;
import com.javabrains.demo.model.Vehicle;

@SpringBootTest
class HibernateJavabrainsApplicationTests {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testRelationships() {
		
		Vehicle vehicle = new Vehicle("Car");
		UserDetails user = new UserDetails("First user");
		
		SessionFactory sessionFactory = 
				this.entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
	}
	

}
