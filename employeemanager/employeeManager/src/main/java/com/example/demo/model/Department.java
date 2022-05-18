package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false ,updatable=false)
	private long id;
	@Column(name="name")
	private String dptName;
	public Department(long id, String deptName) {
		this.id = id;
		this.dptName = deptName;
	}
	public Department() {
	}
	 /*
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
	
	*/
	
	
	
}
