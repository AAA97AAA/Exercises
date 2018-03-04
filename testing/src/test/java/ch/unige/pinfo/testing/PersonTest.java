package ch.unige.pinfo.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class PersonTest {

	@Test
	public void test_Stefan_is_valid() {
		Person p = new Person();
		assertTrue(p.isFirstnameValid("Stefan"));
	}
	
	@Test
	public void test_name_contains_space_expects_false() {
		Person p = new Person();
		assertFalse(p.isFirstnameValid("Stefan Stefan"));
	}
	
	@Test
	public void test_setFirstname_invalid_name_doesnt_write() {
		Person p = new Person();
		p.setFirstname("Stefan Stefan");
		assertNull(p.getFirstname());
	}
	
	@Test
	public void test_setLastname_invalid_name() {
		Personvalidator pv = mock(Personvalidator.class);
		when(pv.validate("Stefan")).thenReturn(false);
		
		Person p = new Person();
		p.setPersonvalidator(pv);
		
		assertFalse(p.setLastname("Stefan"));
		assertNull(p.getLastname());
		
		verify(pv).validate("Stefan");
	}
	
	@Test
	public void test_setLastname_valid_name() {
		Personvalidator pv = mock(Personvalidator.class);
		when(pv.validate("Stefan")).thenReturn(true);
		
		Person p = new Person();
		p.setPersonvalidator(pv);
		
		
		assertTrue(p.setLastname("Stefan"));
		assertEquals(p.getLastname(), "Stefan");
		
		verify(pv).validate("Stefan");
	}

}
