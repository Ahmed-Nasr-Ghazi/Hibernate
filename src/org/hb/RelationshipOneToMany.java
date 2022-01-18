package org.hb;

import java.util.Date;

import org.hb.dto.UserDetailsCollections;
import org.hb.dto.UserDetailsSimple;
import org.hb.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationshipOneToMany {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(UserDetailsCollections.class)
								.addAnnotatedClass(Vehicle.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			UserDetailsCollections userDetails = new UserDetailsCollections("Mohammed", new Date());
			
			Vehicle userVehicle = new Vehicle();
			userVehicle.setVehicleName("Toyota");
			Vehicle userVehicle2 = new Vehicle();
			userVehicle2.setVehicleName("Honda");
			
			userDetails.getVehicleSet().add(userVehicle);
			userDetails.getVehicleSet().add(userVehicle2);

			session.beginTransaction();
			session.save(userDetails);
			session.save(userVehicle);
			session.save(userVehicle2);
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
		
	}

}
