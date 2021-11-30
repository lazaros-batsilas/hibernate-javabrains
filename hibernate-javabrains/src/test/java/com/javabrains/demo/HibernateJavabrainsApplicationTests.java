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
		Set<Address> addresses=new HashSet<Address>();
		addresses.add(new Address("High Street", "Kozani", "GR", "50100"));
		addresses.add(new Address("Main Street", "Thessaloniki", "GR", "12345"));
		session.save(new UserDetails("First user", new Date(), addresses, "description"));
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		System.out.println("user with username is "+user.getUsername());
//		System.out.println("address is "+user.getAddress().toString());
	}
	

}
