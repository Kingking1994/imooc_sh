package com.king.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * 
 * @author king
 *
 */
public class MyHibernateSessionFactory {

	private static SessionFactory factory = null;
	
	private MyHibernateSessionFactory(){
		
	}
	
	public static SessionFactory getInstance(){
		if(factory == null){
			Configuration config = new Configuration().configure();
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			
			factory = config.buildSessionFactory(serviceRegistry);
		}
		return factory;
	}
		
		
	
		
}
