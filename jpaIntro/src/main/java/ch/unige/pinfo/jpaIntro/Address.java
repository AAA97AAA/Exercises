package ch.unige.pinfo.jpaIntro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable{

	private static final long serialVersionUID = -6732124006769701523L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ADDRESS")
	private String address;
	
	@ManyToMany
	private List<Person> persons;
	
	/*
	 * We can create enumerated values! Make sure to annotate it as EnumType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE")
	private AddressType type;

	// default c'tor
	public Address() {
		this.persons = new ArrayList<Person>();
	}
	
	// the c'tor we actually use
	public Address(String address, AddressType type) {
		this.address = address;
		this.type = type;
		this.persons = new ArrayList<Person>();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	
	@Override
	public String toString() {
		return type.toString() + ": " + address;
	}

}
