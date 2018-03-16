package ch.unige.pinfo.jpaIntro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class PersonTest {

	/*
	 * Note that this is not a real test, we don't assert but print to commandline instead
	 */
	@Test
	public void test() {
		// Create objects
		Person stefan = new Person();
		stefan.setFirstname("stefan");
		stefan.setLastname("klikovits");
		
		Person tom = new Person("Tom", "TomTom");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// Persist to database
		em.persist(stefan);
		em.persist(tom);
		// force a flush to the DB
		em.getTransaction().commit();
		
		// query the database
		Query q = em.createQuery("select p from Person p ");
		List<Person> persons = q.getResultList();
		for(Person p : persons){
			System.out.println(p.getFirstname() + " " + p.getLastname());
		}
		
		em.close();
		emf.close();
	}

	/*
	 * Note that this is not a real test, we don't assert but print to commandline instead
	 */
	@Test
	public void test_with_address() {
		Address company = new Address("A work address", AddressType.work);
		
		// Create objects
		Person stefan = new Person();
		stefan.setFirstname("stefan");
		stefan.setLastname("klikovits");
		Address stefansHome = new Address("my home address", AddressType.home);
		stefan.getAddresses().add(stefansHome);
		stefansHome.getPersons().add(stefan);
		stefan.getAddresses().add(company); // two people work at the same address
		company.getPersons().add(stefan);

		Person tom = new Person("Tom", "TomTom");
		tom.getAddresses().add(company);
		company.getPersons().add(tom);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// Persist to database
		em.persist(stefan);
		em.persist(tom);
		em.persist(new Address("other address that is not related to a person", AddressType.other));
		// don't need to persist the other addresses, because they have already been persisted by the persons (through Cascading)
		
		// force a flush to the DB
		em.getTransaction().commit();
		
		// query the database, get all addresses
		Query q = em.createQuery("select p from Person p ");
		List<Person> persons = q.getResultList();
		for(Person p : persons){
			System.out.println(p.toString());
			for(Address a : p.getAddresses()) {
				System.out.println("\t"+a.toString());
			}
		}
		
		System.out.println("* - * - * - * - * - * - * - * - * - * - * - * - *");
		
		// query the database, get all addresses
		Query q2 = em.createQuery("select a from Address a");
		List<Address> addresses = q2.getResultList();
		for(Address a : addresses){
			System.out.println(a.toString());
			// print all persons that are affiliatd with that address
			for(Person p : a.getPersons()) {
				System.out.println("\t" + p.toString());
			}
			
		}
				
		em.close();
		emf.close();
	}
	
}
