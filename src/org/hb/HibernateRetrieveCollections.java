package org.hb;

import org.hb.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRetrieveCollections {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(UserDetails.class)
					.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
/*
 * to make sure that we are using proxy object
 * 
			session.beginTransaction();
			UserDetails userDetails = session.get(UserDetails.class, 1);
			System.out.println(userDetails);
			session.close();
			System.out.println(userDetails.getListOfAddress().size());
*/

		
	}
}
