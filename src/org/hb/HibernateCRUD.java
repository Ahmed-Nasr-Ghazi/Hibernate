package org.hb;

import java.util.Date;

import org.hb.dto.UserDetailsSimple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCRUD {

	public static void main(String[] args) {

		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(UserDetailsSimple.class)
										.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				
				try {	
					/*
					UserDetailsSimple user = new UserDetailsSimple();
					user.setDate(new Date());
					user.setUserName("User 0");
					
					UserDetailsSimple user1 = new UserDetailsSimple();
					user1.setDate(new Date());
					user1.setUserName("User 1");
					
					session.beginTransaction();
					session.save(user);
					session.save(user1);
					
					session.getTransaction().commit();
					*/
					//getting
					session.beginTransaction();
					UserDetailsSimple userGet = session.get(UserDetailsSimple.class, 1);
					System.out.println(userGet);
					
					//Delete
					/*
					userGet = session.get(UserDetailsSimple.class, 3);
					session.delete(userGet);
					session.getTransaction().commit();
			 		*/
					
					
					//Update
					/*
					userGet = session.get(UserDetailsSimple.class, 3);
					userGet.setUserName("Updated");
					session.update(userGet);
					
					session.getTransaction().commit();
					*/
					
					//transiant object
					UserDetailsSimple user = new UserDetailsSimple();
					user.setDate(new Date());
					user.setUserName("User 0"); // Transiant object
					
					session.save(user);
					
					
					user.setUserName("User updated value"); //we are not using session.update but it will be reflected into DB
					
					session.getTransaction().commit();
					session.close(); // detached object
					
					user.setUserName("User updated value"); // will not be persisted 
					
					
				}
				finally {
					session.close(); // detached object
				}
		
	}

}
