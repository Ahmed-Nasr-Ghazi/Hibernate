package org.hb;

import java.util.Date;

import org.hb.dto.UserDetailsSimple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateQueryLanguage {

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
					UserDetailsSimple userGet = session.get(UserDetailsSimple.class, 1);
					session.getTransaction().commit();
					System.out.println(userGet);

					
				}
				finally {
					session.close(); // detached object
				}
				
				session = factory.getCurrentSession();
				session.beginTransaction();
				UserDetailsSimple userGet = session.get(UserDetailsSimple.class, 1);
				session.update(userGet);
				session.getTransaction().commit();

				session.close(); // detached object

		
	}

}
