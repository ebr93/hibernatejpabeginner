package org.test.project.HibernateJPABegin.controller;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.test.project.HibernateJPABegin.models.User;

public class CreatingUser {
	// private static ServiceRegistry registry;
	// private static SessionFactory factory;

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		User uone = new User();
		uone.setEmail("haseeb@gmail.com");
		uone.setFullName("Moh Haseeb");
		uone.setPassword("has123");
		uone.setSalary(2000.69);
		uone.setAge(20);
		uone.setCity("NYC");

		User uTwo = new User();
		uTwo.setEmail("James@gmail.com");
		uTwo.setFullName("James Santana");
		uTwo.setPassword("James123");
		uTwo.setSalary(2060.69);
		uTwo.setAge(25);
		uTwo.setCity("Dallas");

		User uThree = new User();
		uThree.setEmail("Shahparan@gmail.com");
		uThree.setFullName("AH Shahparan");
		uThree.setPassword("Shahparan123");
		uThree.setSalary(3060.69);
		uThree.setAge(30);
		uThree.setCity("Chicago");

		User ufour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3, "NJ");
		User ufive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");

		session.persist(uone);
		session.persist(uTwo);
		session.persist(uThree);
		session.persist(ufour);
		session.persist(ufive);

		tx.commit();

		List<User> list = session.createQuery("from User", User.class).getResultList();
		System.out.println(list);
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}
}
