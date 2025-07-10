package com.hibernateCodes.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteStudentById {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter ID of student to delete: ");
            int id = scanner.nextInt();

            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, id);

            if (student != null) {
                session.delete(student);
                System.out.println("Student with ID " + id + " deleted.");
            } else {
                System.out.println("No student found with ID " + id);
            }

            tx.commit();
        }
    }
}

