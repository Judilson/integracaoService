/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.util;

import static br.com.giex.util.HibernateUtil.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author jjunior
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);
    }

    static {
        try {
            sessionFactory = getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory.openSession();
            return sessionFactory;
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}