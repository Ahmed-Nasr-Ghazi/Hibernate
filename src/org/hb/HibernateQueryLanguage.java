package org.hb;

import java.util.Date;
import java.util.List;

import org.hb.dto.UserDetailsSimple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
					
					Query query = session.createQuery("from UserDetailsSimple");
					query.setFirstResult(4);
					
					List<UserDetailsSimple> list = query.list();
					System.out.println(list);
					query = session.createQuery("select userName from UserDetailsSimple");

					
					list = query.list();
					System.out.println(list);
					session.getTransaction().commit();
					
				}
				
				finally {
					session.close();
				}		
	}

}
