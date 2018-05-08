package com.cis365.week5;

import java.util.List;
import java.util.Iterator;

import com.cis365.week5.models.Customer;
import com.cis365.week5.models.Rep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            /*
            String dbName = System.getenv("RDS_DB_NAME");
            String userName = System.getenv("RDS_USERNAME");
            String password = System.getenv("RDS_PASSWORD");
            String hostname = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;
            */

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List<Customer> listCustomers( ) {
        System.out.print("listCustomers()");

        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List customers = session.createQuery("FROM Customer").list();
            for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
                Customer customer = (Customer) iterator.next();
                System.out.print("Name: " + customer.getCustmomerName());
                System.out.print("  Address: " + customer.getStreetAddress());
            }
            tx.commit();
            return customers;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Rep findRepById(String repNum) {
        Session session = getSessionFactory().openSession();

        try {
            return (Rep) session.get(Rep.class, repNum);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}