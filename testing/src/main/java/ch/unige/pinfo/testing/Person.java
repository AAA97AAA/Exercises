package ch.unige.pinfo.testing;

public class Person {

	private String firstname;
	private String lastname;
	private Personvalidator personvalidator;
	
	//c'tor
	public Person() {
		this.personvalidator = new Personvalidator();
	}
	
	// set validator
	public void setPersonvalidator(Personvalidator personvalidator) {
		this.personvalidator = personvalidator;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public boolean setFirstname(String firstname) {
		if(this.isFirstnameValid(firstname)){
			this.firstname = firstname;
			return true;
		} else {
			return false;
		}
	}

	public boolean isFirstnameValid(String first) {
		if(first.contains(" ")){ // firstname contains space
			return false;
		}
		if(first.matches(".*\\d+.*")){ // contains digits
			return false;
		}
		if(first.toLowerCase().equals(first)){ // contains digits
			return false;
		}
		
		
		return true;
	}

	public String getLastname() {
		return lastname;
	}

	public boolean setLastname(String lastname) {
		if(this.personvalidator.validate(lastname)){
			this.lastname = lastname;
			return true;
		} else {
			return false;
		}
	}
	
}
