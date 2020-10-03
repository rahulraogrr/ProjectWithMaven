package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Student student = new Student();
        student.setId(1);
        student.setName("Harshal Mayee");
        student.setCity("Navi Mumbai");

        Session session = sessionFactory.openSession();

        Transaction transaction = session.getTransaction();

        session.beginTransaction();
        session.save(student);

        transaction.commit();

        session.close();
    }
}
