package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String zip;
	private String email;
	private String phone;

	public Address() {
	}

	public Address(String street, String zip, String email, String phone) {
		super();
		this.street = street;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
