package org.hb;

import org.hb.dto.FourWheeler;
import org.hb.dto.TwoWheeler;
import org.hb.dto.Vehicle;
import org.hb.dto.VehicleInheritance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInheritance {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(VehicleInheritance.class)
								.addAnnotatedClass(TwoWheeler.class)
								.addAnnotatedClass(FourWheeler.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			VehicleInheritance vehicle = new VehicleInheritance();
			TwoWheeler bike = new TwoWheeler();
			FourWheeler car = new FourWheeler();

			vehicle.setVehicleName("CarVehicle");
			
			bike.setVehicleName("Bike");
			bike.setSteeringHandle("Bike Handle");

			car.setVehicleName("Ferrari");
			car.setSteeringHandle("Car SteeringWheel");
			
			session.beginTransaction();
			
			session.save(vehicle);
			session.save(car);
			session.save(bike);
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
