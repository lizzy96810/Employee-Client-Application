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
public class DepartmentDto {
	
	private long idNumber;
	private String deptName;
	public DepartmentDto(long id, String deptName) {
		this.idNumber = id;
		this.deptName = deptName;
	}
	public DepartmentDto() {
	}
	/*
	public long getId() {
		return idNumber;
	}
	public void setId(long id) {
		this.idNumber = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	*/
	
	
	
}
