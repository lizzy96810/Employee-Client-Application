import { EmployeeService } from './../employee.service';
import { Employee } from './../employee.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DepartmentService } from '../department.service';
import { Department } from '../deparment.model';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employee: Employee = new Employee();
  departments: Department [];
  constructor(private employeeService:EmployeeService,
              private departmentService:DepartmentService,
              private router:Router) { }

  ngOnInit(): void {
    this.getDepartmentList();
  }
  saveEmployee(){
    this.employeeService.saveEmployee(this.employee).subscribe(data =>{
      this.employee =data;
      console.log(this.employee);
      this.goToEmployeeList();
    },error =>console.log(error));
  }
   getDepartmentList() {
    this.departmentService.getDepartmentList().subscribe(data =>{
      this.departments = data;
    })
  }
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  selectChangeHandler(event:any){
    this.employee.dptId = event.target.value;
  }
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
