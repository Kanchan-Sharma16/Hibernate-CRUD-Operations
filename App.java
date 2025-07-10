package com.hibernateCodes.DemoHibernate;

// HQL - to retreive data from db

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {
public static void main(String[] args){
		
		// create session
		Session session = HibernateFinalClass.getfactory().openSession();
		
		// start transaction
		Transaction tx = session.beginTransaction();
		
		Query q = session.createQuery("from Student");
		List <Student> students = q.list();
		
		for(Student s :students ) {
			System.out.println(s);
		}
		
		//save record to database
//		session.persist(s);
		tx.commit();
	}
}
