package hb.demo3;

import hb.demo3.model.HealthInsurance;
import hb.demo3.model.InsuranceDao;
import hb.demo3.model.TermInsurance;
import hb.demo3.model.VehicleInsurance;

public class Main {

	public static void main(String[] args) {
		
		HealthInsurance health = new HealthInsurance();
		TermInsurance term = new TermInsurance();
		VehicleInsurance vehicle = new VehicleInsurance();
		
//		health.setId(1);
		health.setName("Ashish");
		health.setHealthPlan("Complete");
		health.setSumInsured(200000);
		
//		term.setId(2);
		term.setName("Rahul");
		term.setSumInsured(1000000);
		term.setYears(30);
		
//		vehicle.setId(3);
		vehicle.setName("Vijay");
		vehicle.setSumInsured(400000);
		vehicle.setVehicle("Car");
		
		InsuranceDao insDao = new InsuranceDao();
		
		System.out.println("Creating vehicle insurance...");
		insDao.create(vehicle);
		
		System.out.println("Creating term insurance...");
		insDao.create(term);
		
		System.out.println("Creating health insurance...");
		insDao.create(health);
		
		InsuranceDao.shutdown();

	}

}
