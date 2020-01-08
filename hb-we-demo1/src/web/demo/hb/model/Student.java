package web.demo.hb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_students")
public class Student {

	private String name;

	@Id
	private String email;

	private String phone;

	private String batch;

	public Student() {
	}

	public Student(String name, String email, String phone, String batch) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.batch = batch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", phone=" + phone + ", batch=" + batch + "]";
	}

}
