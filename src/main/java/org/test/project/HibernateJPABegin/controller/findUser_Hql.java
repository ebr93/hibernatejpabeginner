package org.test.project.HibernateJPABegin.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.test.project.HibernateJPABegin.models.User;

public class findUser_Hql {

	/*
	 * a) THE FROM Clause: Create a class named findUser_Hql.java under the
	 * com.test.hib.controller package. and add the following code. In the following
	 * example, we will use the “From User” clause.
	 */
	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User"; // Example of HQL to get all records of user class
		Query query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullName() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	/*
	 * b) SELECT Clause Create one more method named findUserSelect() in the
	 * findUser_Hql class. In this method, we will use the “Select” clause as shown
	 * below:
	 */

	public void findUserSelect() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		/* ------------ Example of HQL to get all the records------- */
		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();

		for (User u : list) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullName() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());

		}
	}

	/*
	 * c) WHERE Clause and Order by Clause Create one more method named
	 * “getRecordbyId()” in findUser_Hql class. In this method, we will use the
	 * “Where and Order by” clause as shown below
	 */

	public void getRecordbyId() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User E WHERE E.id > 2 ORDER BY E.salary DESC";
		Query query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullName() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	/*
	 * d) Multiple SELECT Expressions Create one more method named "getrecords()''
	 * in the findUser_Hql class. In this method, we will use the multiple columns
	 * as shown below:
	 * 
	 */

	public void getrecords() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query<Object[]> queryy = session.createQuery("SELECT U.salary, U.fullName FROM User AS U", Object[].class);
		List<Object[]> resultss = queryy.getResultList();
		for (Object[] a : resultss) {
			System.out.println("Salary: " + a[0] + ", City: " + a[1]);
		}
	}

	/*
	 * e) Example: Aggregate Function Create one more method named "getmaxSalary()”
	 * in the findUser_Hql class. In this method, we will use the “max()” function
	 * as shown below: Note: We will use the getSingleResult() method. This method
	 * executes a SELECT query that returns a single untyped result.
	 */

	public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT max(U.salary), U.fullName FROM User U";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> results = query.getResultList();
		for (Object[] a : results) {
			System.out.println("Maximum Salary: " + ((double) a[0]) + ", Employee: " + a[1]);
		}
	}

	/*
	 * f) GROUP BY Clause and Aggregate function Create one more method named
	 * "getmaxSalaryGroupBy()” in the findUser_Hql class. In this method, we will
	 * use the Group By clause and “max()” function as shown below:
	 */

	public void getmaxSalaryGroupBy() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> result = query.getResultList();
		for (Object[] o : result) {
			System.out.println("Total salary " + o[0] + " | city: " + o[1]);
		}
	}

	public void NamedQueryExample() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User u WHERE u.id = :id";
		Query query = session.createQuery(hql, User.class);
		query.setParameter("id", 2);
		List<User> result = query.getResultList();
		for (User u : result) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullName() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

}
