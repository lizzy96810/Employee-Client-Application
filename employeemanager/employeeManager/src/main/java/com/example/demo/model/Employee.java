package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false ,updatable=false)
	private long id;
	private String name;
	private String email;
	private String phone;
	
	@ManyToOne
	private Department department;
	
	
	
	public Employee(long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

   /*
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	*/
}
