package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.model.EmployeeListDto;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
	//@Query("select new com.example.demo.model.EmployeeListDTO( e.id, e.name,  e.email, e.phone) from Employee e")
	//List<EmployeeListDTO> getEmployeeByDepartment();
	
	@Query("select new com.example.demo.model.EmployeeListDto( e.id, e.name,  e.email, e.phone, d.dptName) from Employee e JOIN e.department d")
	List<EmployeeListDto> getEmployeeByDepartment();
	List<Employee> findByDepartmentId(Long id);
	
	
	
}

