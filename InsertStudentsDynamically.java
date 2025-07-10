package com.hibernateCodes.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertStudentsDynamically {
    public static void main(String[] args) {

        Configuration cfg = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession();
             Scanner scanner = new Scanner(System.in)) {

            Transaction tx = session.beginTransaction();

            System.out.print("How many students do you want to insert? ");
            int count = scanner.nextInt();
            scanner.nextLine();  // consume newline

            for (int i = 0; i < count; i++) {
                System.out.print("Enter name of student " + (i + 1) + ": ");
                String name = scanner.nextLine();

                Student s = new Student();
                s.setSname(name);

                session.save(s);
            }

            tx.commit();  // Final commit to DB
            System.out.println("Students inserted successfully!");
        }
    }
}
