package com.hibernateCodes.DemoHibernate;

import org.hibernate.Session;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StartApplication {

	public static void main(String[] args){
		
		// create session
		Session session = HibernateFinalClass.getfactory().openSession();
		
		// start transaction
		Transaction tx = session.beginTransaction();
		
		Student s1 = new Student();
		s1.setSname("Neha");
		
		//save record to database
		session.persist(s1);
		tx.commit();
	}

}
