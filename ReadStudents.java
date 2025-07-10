package com.hibernateCodes.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class ReadStudents {
    public static void main(String[] args) {

       Student s = null;
       Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
       ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
       SessionFactory sf = con.buildSessionFactory(reg);
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       s = (Student) session.get(Student.class, 4);
       tx.commit();
       System.out.println(s);
       
       
    }
}
