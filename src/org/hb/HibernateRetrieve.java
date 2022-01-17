package org.hb;

import java.util.Date;

import org.hb.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRetrieve {

	public static void main(String[] args) {

		//Only one per application
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UserDetails.class)
				.buildSessionFactory();

		// create session
		Session session = factory.openSession();
		
		UserDetails userDetails =  new UserDetails();
		session.beginTransaction();
		userDetails = session.get(UserDetails.class, 1);
		System.out.println(userDetails);
		session.getTransaction().commit();
		session.close();
		
	}

}
