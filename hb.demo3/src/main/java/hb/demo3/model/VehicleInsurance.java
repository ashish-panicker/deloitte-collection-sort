package hb.demo3.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_ins_details")
//@DiscriminatorValue(value = "V_I")
public class VehicleInsurance extends Insurance {

	@Column(name = "insured_vehicle_type")
	private String vehicle;

	public VehicleInsurance() {
	}

	public VehicleInsurance(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}
