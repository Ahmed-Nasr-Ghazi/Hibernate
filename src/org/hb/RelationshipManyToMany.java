package org.hb;

import java.util.Date;

import org.hb.dto.RentalVehicle;
import org.hb.dto.UserDetailsCollections;
import org.hb.dto.UserDetailsCollectionsM2M;
import org.hb.dto.UserDetailsSimple;
import org.hb.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationshipManyToMany {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(UserDetailsCollectionsM2M.class)
								.addAnnotatedClass(Vehicle.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			UserDetailsCollectionsM2M userDetails = new UserDetailsCollectionsM2M("Mohammed", new Date());
			
			RentalVehicle userVehicle = new RentalVehicle();
			userVehicle.setVehicleName("Rental Toyota");
			RentalVehicle userVehicle2 = new RentalVehicle();
			userVehicle2.setVehicleName("Rental Honda");
			
			//uni direction relation
			userDetails.getVehicleSet().add(userVehicle);
			userDetails.getVehicleSet().add(userVehicle2);

			//bi-directional relation
			userVehicle.getUserList().add(userDetails);
			userVehicle2.getUserList().add(userDetails);

			//begin transactions
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
