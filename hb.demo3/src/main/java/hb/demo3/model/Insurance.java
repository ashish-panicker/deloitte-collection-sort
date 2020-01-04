package hb.demo3.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "insurance_details", 
	uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "ins_type", discriminatorType = DiscriminatorType.STRING)
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ins_seq")
	@SequenceGenerator(name = "ins_seq", sequenceName = "ins_seq", allocationSize = 2, initialValue = 10)
	@Column(name = "ins_id")
	private int id;

	
	@Column(name = "ins_amt", nullable = false)
	private int sumInsured;

	@Column(name = "ins_name")
	private String name;

	public Insurance() {

	}

	public Insurance(int id, int sumInsured, String name) {
		this.id = id;
		this.sumInsured = sumInsured;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
