package org.example;

import org.example.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class AddressApp {
    public static void main(String[] args) throws IOException {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Address rahul = new Address();
        Address gyr = new Address();
        Address hindu = new Address();

        rahul.setAddress1("405, Gopinath Apartment");
        rahul.setAddress2("Plot No 1027, Sector 9");
        rahul.setAddress3("Airoli");
        rahul.setLandmark("Beside Dharma Tower");
        rahul.setCity("Navi Mumbai");
        rahul.setState("Maharashtra");
        rahul.setCountry("India");
        rahul.setRegion("Asia");
        rahul.setPinCode(400708);
        rahul.setOpen(true);
        rahul.setArea(500.20);
        rahul.setAddedDate(new Date());

        gyr.setAddress1("E-87, OCC COLONY");
        gyr.setAddress2("Orient Cement Company");
        gyr.setAddress3("Kasipet Mandal, Mancheriyal District");
        gyr.setLandmark("Temple Lane");
        gyr.setCity("Devapur");
        gyr.setState("Telangana");
        gyr.setCountry("India");
        gyr.setRegion("Asia");
        gyr.setPinCode(504218);
        gyr.setOpen(true);
        gyr.setArea(20.20);
        gyr.setAddedDate(new Date());

        hindu.setAddress1("HNO 2/1/23");
        hindu.setAddress2("15 Bryan Road");
        hindu.setAddress3("Queens Street");
        hindu.setLandmark("St. Bernard Church");
        hindu.setCity("Auckland");
        hindu.setState("");
        hindu.setCountry("New Zealand");
        hindu.setRegion("Pacific");
        hindu.setPinCode(15214);
        hindu.setOpen(true);
        hindu.setArea(20.20);
        hindu.setAddedDate(new Date());

        FileInputStream fileInputStream = new FileInputStream("src/main/java/rahul.png");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        rahul.setImage(data);
        gyr.setImage(data);
        hindu.setImage(data);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        session.beginTransaction();

        //Persist Data Starts
        session.save(rahul);
        session.save(gyr);
        session.save(hindu);
        //Persist Data Ends

        transaction.commit();

        //Close Objects
        fileInputStream.close();
        session.close();
        sessionFactory.close();
    }
}
