package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepo;

@RestController
@RequestMapping("/deparment")
public class DepartmentController {
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@PostMapping("/save")
	public ResponseEntity <Department> saveDepartment(@RequestBody Department department){
		departmentRepo.save(department);
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("/all")
	public ResponseEntity <List<Department>> getAllDepartments() {
		List<Department> departmentList = departmentRepo.findAll();
		return ResponseEntity.ok(departmentList);
	}
	
	@GetMapping("/find/{id}")
	public Optional<Department> getDeparmentById(@PathVariable("id") Long id) {
		Optional<Department> department= departmentRepo.findById(id);
		return department;
	}
	
	@PutMapping("/update")
	public ResponseEntity <Department> updateDeparment(@RequestBody Department department){
		Department updatedDepartment = departmentRepo.save(department);
		return ResponseEntity.ok(updatedDepartment);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteDepartment(@PathVariable("id")Long id) {
		Map<String,Boolean> deleteStatus = new HashMap<String,Boolean>();
		departmentRepo.deleteById(id);
		deleteStatus.put("deleted",true);
		return ResponseEntity.ok(deleteStatus);
	}
}
