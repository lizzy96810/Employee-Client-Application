package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import com.example.demo.model.DepartmentDto;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;

import com.example.demo.model.EmployeeListDto;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepository;
	@Autowired
	private DepartmentRepo departmentRepo;
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		Employee employee = new Employee();
		employee.setEmail(employeeDTO.getEmail());
		employee.setName(employeeDTO.getName());
		employee.setPhone(employeeDTO.getPhone());
		employee.setDepartment(departmentRepo.getById(employeeDTO.getDptId()));
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> employeeList = employeeRepository.findAll();
		//List<EmployeeDTO> employeeList = employeeRepository.getEmployeeByDepartment();
		return ResponseEntity.ok(employeeList);
	}
	
	@GetMapping("/empByDept")
	public ResponseEntity<List<EmployeeListDto>> getEmployeeByDept(){
		List<Employee> employeeList = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		List<EmployeeListDto> empDtos = new ArrayList<EmployeeListDto>();
		EmployeeListDto empDto;
		for(Employee emp: employeeList) {
			empDto = new EmployeeListDto();
			BeanUtils.copyProperties(emp, empDto);
			empDto.setDeptName(emp.getDepartment().getDptName());
			System.out.println(empDto.getDeptName());
			empDtos.add(empDto);
		}
		return ResponseEntity.ok(empDtos);
	}
	@GetMapping("/getDeptList")
	public ResponseEntity<List<DepartmentDto>> getDeptList(){
		List<DepartmentDto> departmentList = departmentRepo.getDeptList();
		for(DepartmentDto dto: departmentList) {
			System.out.println(dto.getDeptName());
			
		}
		return ResponseEntity.ok(departmentList);
	}
	
	@GetMapping("/find/{id}")
	public Optional<Employee> getEmployeById(@PathVariable ("id") Long id) {
		Optional<Employee> employee= employeeRepository.findById(id);
		return employee;
	}
	
	@GetMapping("/employeeByDept/{id}")
	public ResponseEntity <List<EmployeeListDto>> getEmployeeByDeptId(@PathVariable ("id")Long id) {
		List<Employee> empList = employeeRepository.findByDepartmentId(id);
		EmployeeListDto empDto;
		List<EmployeeListDto> empDtoList = new ArrayList<EmployeeListDto>();
		for(Employee emp:empList) {
		  empDto = new EmployeeListDto();	
		  BeanUtils.copyProperties(emp, empDto);
		  empDto.setDeptName(emp.getDepartment().getDptName());
		  empDtoList.add(empDto);
		}
		 return ResponseEntity.ok(empDtoList);
	}
	
	@PutMapping("/update")
	public ResponseEntity <Employee> updateEmployee( @RequestBody Employee employee){
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id")Long id) {
		Map<String,Boolean> deleteStatus = new HashMap<String,Boolean>();
		employeeRepository.deleteById(id);
		deleteStatus.put("deleted",true);
		return ResponseEntity.ok(deleteStatus);
	}
	
}
