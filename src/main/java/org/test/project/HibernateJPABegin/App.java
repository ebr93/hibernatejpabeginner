package org.test.project.HibernateJPABegin;

import org.test.project.HibernateJPABegin.controller.findUser_Hql;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		findUser_Hql fhql = new findUser_Hql();
		//fhql.findUser();
		
		//fhql.findUserSelect();
		
		fhql.getRecordbyId();
		
		fhql.getrecords();
		
		fhql.getmaxSalary();
		
		fhql.getmaxSalaryGroupBy();
		
		fhql.NamedQueryExample();
	}
}
