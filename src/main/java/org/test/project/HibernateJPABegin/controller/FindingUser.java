package org.test.project.HibernateJPABegin.controller;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.test.project.HibernateJPABegin.models.User;

public class FindingUser {
	//private static ServiceRegistry registry;
	//private static SessionFactory factory;

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		int USER_ID = 2;
		User u = session.get(User.class, USER_ID);
		System.out.println("Fullname: " + u.getFullName());
		System.out.println("Email: " + u.getEmail());
		System.out.println("password: " + u.getPassword());

		// Close resources
		tx.commit();
		factory.close();
		session.close();

	}
}
