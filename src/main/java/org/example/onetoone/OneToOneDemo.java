package org.example.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args) {
        System.out.println( "One To One Demo" );
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Question question1 = new Question();
        Question question2 = new Question();

        question1.setQuestionId(101);
        question1.setQuestion("What is Java?");
        Answer answer1 = new Answer();
        answer1.setAnswerId(201);
        answer1.setAnswer("Java is a programming language");
        question1.setAnswer(answer1);

        question2.setQuestionId(102);
        question2.setQuestion("What is IntelliJ Idea");
        Answer answer2 = new Answer();
        answer2.setAnswerId(202);
        answer2.setAnswer("IntelliJ is an Integrated Development Environment");
        question2.setAnswer(answer2);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question1);
        session.save(question2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
