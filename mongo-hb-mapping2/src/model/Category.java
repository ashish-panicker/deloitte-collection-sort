package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Category {

	@Id
	@GeneratedValue(generator = "uid")
	@GenericGenerator(name = "uid", strategy = "uuid2")
	private String id;

	private String name;

	private String description;

	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
