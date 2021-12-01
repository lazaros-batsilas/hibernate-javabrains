package com.javabrains.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		Vehicle vehicle2 = new Vehicle("Jeep");
		List<Vehicle> vehicles= new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		vehicles.add(vehicle2);
		UserDetails user = new UserDetails("First user", vehicles);
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory = 
				this.entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
	}
	

}
