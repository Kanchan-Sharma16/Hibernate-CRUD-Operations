package com.hibernateCodes.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {

        Configuration cfg = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, id);

            if (student != null) {
                System.out.println("Current name: " + student.getSname());

                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();

                student.setSname(newName);  // Hibernate auto-tracks changes

                // session.update(student);  // Optional in persistent context
                tx.commit();  // Changes will be flushed to DB

                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
                tx.rollback();
            }
        }
    }
}

