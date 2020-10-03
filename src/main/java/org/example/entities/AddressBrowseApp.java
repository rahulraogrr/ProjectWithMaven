package org.example.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddressBrowseApp {
    public static void main(String[] args) {
        System.out.println("Browse Address Table Data");
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        //Browse Data
        /**
         * Returns null when data not found in db
         */
        Address address = session.get(Address.class,20);
        System.out.println(address);

        /**
         * It will throw ObjectNotFound Exception when data is not found in database
         */
        Address addressLoadMethod = session.load(Address.class,20);
        //System.out.println(addressLoadMethod);

        session.close();
        sessionFactory.close();
    }
}