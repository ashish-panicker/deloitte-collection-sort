package model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(generator = "uid")
	@GenericGenerator(name = "uid", strategy = "uuid2")
	private String id;

	private String name;

	@Embedded
	private Address publisherAddress;

	public Publisher() {
	}

	public Publisher(String name, Address publisherAddress) {
		this.name = name;
		this.publisherAddress = publisherAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(Address publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

}
