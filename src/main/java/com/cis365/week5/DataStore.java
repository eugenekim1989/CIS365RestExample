package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import com.cis365.week5.models.Starship;
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

       public static List<Planet> listPlanets( ) {
        System.out.print("listPlanets()");

        Session session = getSessionFactory().openSession();


        try {
            List planets = session.createQuery("FROM Planet").list();
            return planets;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet updatePlanet(String planetId, Planet planetInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            existing.setAtmosphere(planetInput.getAtmosphere());
            existing.setName(planetInput.getName());
            existing.setRadius(planetInput.getRadius());
            System.out.println("Planet "+planetId+" has been updated");
            session.update(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet addPlanet(Planet planetInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = new Planet();
            existing.setPlanetId(planetInput.getPlanetId());
            existing.setAtmosphere(planetInput.getAtmosphere());
            existing.setName(planetInput.getName());
            existing.setRadius(planetInput.getRadius());
            System.out.println("Planet "+existing.getPlanetId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet deletePlanet(String planetId){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = new Planet();
            existing.setPlanetId(planetId);
            session.delete(existing);
            System.out.println("Planet "+planetId+" has been deleted");
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship updateStarship(String starShipId, Starship starshipInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = findStarshipById(starShipId);
            existing.setName(starshipInput.getName());
            existing.setCrewSize(starshipInput.getCrewSize());
            existing.setShipClass(starshipInput.getShipClass());
            existing.setLaunchStarDate(starshipInput.getLaunchStarDate());
            System.out.println("Starship "+starShipId+" has been updated");
            session.update(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship addStarship(Starship starshipInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = new Starship();
            existing.setStarShipId(starshipInput.getStarShipId());
            existing.setName(starshipInput.getName());
            existing.setCrewSize(starshipInput.getCrewSize());
            existing.setShipClass(starshipInput.getShipClass());
            existing.setLaunchStarDate(starshipInput.getLaunchStarDate());
            System.out.println("Starship "+existing.getStarShipId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship deleteStarship(String starshipId){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = new Starship();
            existing.setStarShipId(starshipId);

            session.delete(existing);
            System.out.println("Planet "+starshipId+" has been deleted");
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Starship> listStarships( ) {
        System.out.print("listStarships()");

        Session session = getSessionFactory().openSession();

        try {
            List starships = session.createQuery("FROM Starship").list();
            return starships;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<PlanetVisit> listPlanetVisits( ) {
        System.out.print("listPlanetVisits()");

        Session session = getSessionFactory().openSession();

        try {
            List planetvisits = session.createQuery("FROM Planetvisit").list();
            return planetvisits;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

     public static PlanetVisit addPlanetVisit(PlanetVisit planetVisitInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            PlanetVisit existing = new PlanetVisit();
            existing.setPlanetId(planetVisitInput.getPlanetId());
            existing.setStarshipID(planetVisitInput.getStarshipID());
            //existing.setArrivalStarDate(planetVisitInput.getArrivalStarDate());
            //existing.setDepartureStarDate(planetVisitInput.getDepartureStarDate());
            System.out.println("Planet Visit "+existing.getPlanetId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship findStarshipById(String starshipId) {
        Session session = getSessionFactory().openSession();
        try {
            return (Starship) session.get(Starship.class, starshipId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet findPlanetById(String planetId) {
        Session session = getSessionFactory().openSession();
        try {
            return (Planet) session.get(Planet.class, planetId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    
}
