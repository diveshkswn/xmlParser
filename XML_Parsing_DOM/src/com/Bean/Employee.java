package com.Bean;

public class Employee {

	public String id;
	public String firstName;
	public String lastName;
	public String location;
	
	
	public Employee() {
		//super();
	}
	public Employee(String id, String firstName, String lastName, String location) {
		//super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Id="+id+"\n FirstName="+firstName+"\n LastName="+lastName+"\n Location="+location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
