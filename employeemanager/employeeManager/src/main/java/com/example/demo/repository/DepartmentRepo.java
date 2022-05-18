package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentDto;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
	@Query("select new com.example.demo.model.DepartmentDto(d.id, d.dptName) from Department d")
	List<DepartmentDto> getDeptList();

}
