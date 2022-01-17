package org.hb;


import java.util.Date;

import org.hb.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSave {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(UserDetails.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new user object...");

			UserDetails userDetails =  new UserDetails();
			userDetails.setUserName("Ahmed");
			userDetails.setDate(new Date());
			// start a transaction
			session.beginTransaction();
			
			// save the user object
			session.save(userDetails);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}






