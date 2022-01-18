package org.hb;

import java.util.Date;

import org.hb.dto.UserDetailsSimple;
import org.hb.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationshipOneToOne {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(UserDetailsSimple.class)
								.addAnnotatedClass(Vehicle.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			UserDetailsSimple userDetails = new UserDetailsSimple("Ahmed", new Date());
			
			Vehicle userVehicle = new Vehicle();
			userVehicle.setVehicleName("Toyota");
			userDetails.setVehicle(userVehicle);
			
			session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
		
	}

}
