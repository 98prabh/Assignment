// Hibernate.util class
// having connection with the Image MAnagmnet Utility database
package com.assignment.hibernateutil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.assignment.model.ImageInfo;
import com.assignment.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	        try {
	            Configuration configuration = new Configuration();
	
	            Properties settings = new Properties();
	            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/imageutility?useSSL=false");
	            settings.put(Environment.USER, "root");
	            settings.put(Environment.PASS, "root");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	
	            settings.put(Environment.SHOW_SQL, "true");
	
	            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	
	            settings.put(Environment.HBM2DDL_AUTO, "update");
	
	            configuration.setProperties(settings);
	            configuration.addAnnotatedClass(User.class);
	            configuration.addAnnotatedClass(ImageInfo.class);

	
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();
	            System.out.println("Hibernate Java Config serviceRegistry created");
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            return sessionFactory;
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return sessionFactory;
	}
}
