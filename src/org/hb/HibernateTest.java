package org.hb;

import org.hb.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

//service
public class HibernateTest {

	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		


		//Only one per application
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UserDetails.class)
				.buildSessionFactory();

		// create session
		Session session = factory.openSession();
		
		UserDetails userDetails =  new UserDetails();
		userDetails.setUserId(7);
		userDetails.setUserName("Mohammed");
		userDetails.setDate(new Date());
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		userDetails = null;

		session = factory.openSession();
		session.beginTransaction();
		userDetails = session.get(UserDetails.class, 1);
		System.out.println(userDetails);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
