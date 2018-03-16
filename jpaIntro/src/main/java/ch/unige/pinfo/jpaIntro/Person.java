package ch.unige.pinfo.jpaIntro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 40951407341483455L;

	/*
	 * It is also possible to annotate other places of your entity.
	 * For more check here:
	 */
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	// cascase type "persist" says that addresses are stored when the person is persisted
	@ManyToMany(mappedBy="persons", cascade=CascadeType.PERSIST)
	private List<Address> addresses;
	
	/*
	 * Note that an entity needs a default constructor.
	 */
	public Person() {
		this.addresses = new ArrayList<Address>();
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.addresses = new ArrayList<Address>();
	}
	
	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Address> getAddresses() {
		return addresses;
	}
	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname();
	}
}
