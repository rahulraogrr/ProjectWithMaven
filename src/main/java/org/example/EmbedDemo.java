package org.example;

import org.example.entities.Certificate;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Student student = new Student();

        student.setId(1);
        student.setName("Rahul Rao");
        student.setCity("Navi Mumbai");

        Certificate certificate = new Certificate();
        certificate.setCourse("Python");
        certificate.setDuration("1 Year");

        student.setCertificate(certificate);

        Student student2 = new Student();

        student2.setId(2);
        student2.setName("Rohit Rao");
        student2.setCity("Hyderabad");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Oracle DBA");
        certificate2.setDuration("2 Year");

        student2.setCertificate(certificate2);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        session.beginTransaction();

        //Persist Data Starts
        session.save(student);
        session.save(student2);
        //Persist Data Ends

        transaction.commit();

        //Close Objects
        session.close();
        sessionFactory.close();

    }
}
