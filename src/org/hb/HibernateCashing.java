package org.hb;

import org.hb.dto.UserDetailsSimple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCashing {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(UserDetailsSimple.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();

			UserDetailsSimple userDetailsSimple = session.get(UserDetailsSimple.class, 1);
						
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();

			UserDetailsSimple userDetailsSimple2 = session.get(UserDetailsSimple.class, 1);

			
		}finally {
			session.close();
		}

	}

}
