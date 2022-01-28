package org.hb;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
					
					Query<UserDetailsSimple> query = session.createQuery("from UserDetailsSimple");
					query.setFirstResult(4);
					
					List<UserDetailsSimple> list = query.list(); //it hits the db
					//System.out.println(list);
					query = session.createQuery("select new map(userId, userName) from UserDetailsSimple");

					
					list = query.list(); //first level will be list
					//System.out.println(list);
					for(int i = 0; i < list.size(); i++) {
						Map<Integer, String> map = (Map<Integer, String>)list.get(i);
						//System.out.println(map);
						
						//System.out.println(list.get(i));
					}
					session.getTransaction().commit();
					
					////////////*///////////
					
					session = factory.getCurrentSession();
					session.beginTransaction();
					/*
					String value = "1";
					query = session.createQuery("from UserDetailsSimple where userId > :value");
					query.setParameter("value", Integer.parseInt(value));
					list = query.list(); //first level will be list
					System.out.println(list);
					
					value = "2";
					
					query = session.createQuery("from UserDetailsSimple where userId = ?1");
					query.setParameter(1, Integer.parseInt(value));
					list = query.list(); //first level will be list
					System.out.println(list);

					query = session.getNamedQuery("UserDetailsSimple.byId");
					query.setParameter("value", Integer.parseInt(value));
					list = query.list(); //first level will be list
					System.out.println(list);
					*/
					// named native query
					
					String name = "User 1";
					query = session.getNamedNativeQuery("UserDetailsSimple.byName");
					query.setParameter("name", name);
					list = query.list(); //first level will be list
					System.out.println(list);
					
					session.getTransaction().commit();

					
					
					
					
				}
				
				finally {
					session.close();
				}		
	}

}
