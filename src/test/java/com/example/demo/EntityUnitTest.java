package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.entities.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

	@Autowired
	private TestEntityManager entityManager;

	private Doctor d1;

	private Patient p1;

    private Room r1;

    private Appointment a1;
    private Appointment a2;
    private Appointment a3;

    
    @Test
    void testAppointmentSetId() {
    	a1 = new Appointment();
    	a1.setId(5);
    	AssertEquals(5,a1.getId());
    }
    
    @Test
    void testGetStartsAt() {
    	p1 = new Patient();
    	d1 = new Doctor();
    	a1 = new Appointment(p1,d1,"19:30 24/04/2023","20:30 24/04/2023");
    	localDateTime startsAt = a1.getStartsAt();
    	AssertEquals(startsAt,"19:30 24/04/2023");
    	
    }
    
  
    
    @Test
    @void testSetStartsAt(){
    	a1 = new Appointment();
    	a1.setStartsAt("19:00 24/04/2023");
    	AssertEquals("19:00 24/04/2023", a1.getStartsAt());
    }
    
    @Test
    void testGetFinishesAt() {
    	p1 = new Patient();
    	d1 = new Doctor();
    	a1 = new Appointment(p1,d1,"19:30 24/04/2023","20:30 24/04/2023");
    	localDateTime finishesAt = a1.getFinishesAt();
    	AssertEquals(finishesAt,"20:30 24/04/2023");
    
    }
    
    
    @Test
    void testSetStartsAt(){
    	a1 = new Appointment();
    	a1.setFinishesAt("20:00 24/04/2023");
    	AssertEquals("20:00 24/04/2023", a1.getFinishesAt());
    }
    
    @Test
    void testgetPatient() {
    	p1 = new Patient("Maria","Fernandez",35,"inventado@gmail.com");
    	d1 = new Doctor("Olga","Lopez",40,"inventado2@gmail.com");
    	r1 = new Room("Dermatologia");
    	a1 = new Appointment(p1,d1,r1,"19:30 24/04/2023","20:30 24/04/2023");
    	
    	
   
    }
    
    @Test 
    void testGetFirstNamePerson() {
    	p1 = new Patient("Maria","Fernandez",35,"inventado@gmail.com");
    	String firstName = p1.getName();
    	AssertEquals(firstName,"Maria");
    }
    
    @Test
    void testSetFirstNamePerson() {
    	p1 = new Patient();
    	p1.setFirstName("Maria");
    	AssertEquals("Maria",p1.getFirstName());
    }
    
    
    @Test
    void testGetLastNamePerson() {
    	d1 = new Doctor("Maria","Fernandez",35,"inventado@gamil.com");
    	String lastName = d1.getLastName();
    	AssertEquals(lastName,"Fernandez");
    }
    
    @Test
    void testSetLastNamePerson() {
    	d1 = new Doctor();
    	d1.setLastName("Fernandez");
    	AssertEquals("Fernandez",d1.getLastName());
    }
   
   
    @Test 
    void testGetAgePerson() {
    	p1 = new Patient("Maria","Fernandez",35,"inventado@gamil.com");
    	int age = p1.getAge();
    	AssertEquals(age,35);
    }
    
    @Test 
    void testSetAgePerson() {
    	d1 = new Doctor();
    	d1.setAge(35);
    	AssertEquals(35,d1.getAge());
    }
    
    @Test
    void testsetId() {
    	p1.setID(7);
    	assertEquals(7,p1.getId());
    }

    @Test
    void testGetMailPerson() {
    	p1 = new Patient("Maria","Fernandez",35,"inventado@gamil.com");
    	String email = p1.getEmail();
    	AssertEquals(email,"inventado@gmail.com");
    }
    
    @Test
    void testSetMailPerson() {
    	d1 = new Doctor();
    	d1.setEmail("inventado@gmail.com")
    	AssertEquals(d1.getEmail(),"inventado@gmail.com");
    }
    
    @Test
    void testSetIdPatient() {
    	p1 = new Patient();
    	p1.setId(7);
    	AssertEquals(7,p1.getId());
    }
    
    @Test
    void testSetIdDoctor() {
    	d1 = new Doctor();
    	11.setId(7);
    	AssertEquals(7,d1.getId());
    }
    
    @Test
    void testGetRoomName() {
    	r1 = new Room("Dermatologia");
    	String roomName = r1.getRoomName();
    	AssertEquals("Dermatologia",roomName);
    }
    
    
    /** TODO
     * Implement tests for each Entity class: Doctor, Patient, Room and Appointment.
     * Make sure you are as exhaustive as possible. Coverage is checked ;)
     */
}
