package com.hibernateCodes.DemoHibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HibernateFinalClass {
	private static final SessionFactory factory;
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getfactory() {
		return factory;
	}

}
