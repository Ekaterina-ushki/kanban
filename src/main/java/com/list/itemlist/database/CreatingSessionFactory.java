package com.list.itemlist.database;

import com.list.itemlist.model.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatingSessionFactory {
    private static SessionFactory sessionFactory;

    private CreatingSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Item.class);
                sessionFactory = configuration.buildSessionFactory();
                System.out.println("The connection to the DBMS is complete.");

            } catch (Exception e) {
                System.out.println("EXCEPTION!!!   " + e);
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}