import { DepartmentService } from './../department.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { Department } from '../deparment.model';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees:Employee[];
  departments:Department[];
  department: Department = new Department();
   
  constructor(private employeeService:EmployeeService,
              private departmentService:DepartmentService,
              private router:Router) { }

  ngOnInit(): void {
    this.getEmployees();
    this.getDepartments();
  }
  
  getDepartments(){
    this.departmentService.getDepartmentList().subscribe(data =>{
      this.departments = data;
    })
  }

  changeEventHandler(event:any){
    this.department.id = event.target.value;
    this.getEmployeesByDeptId();
  }

  getEmployeesByDeptId(){
    this.employeeService.getEmployeeByDeptId(this.department.id).subscribe(data =>{
      this.employees = data;
    })
  }
  getEmployees() {
    this.employeeService.getEmployeeList().subscribe(data =>{
      this.employees = data;
      
    }
      )
  }

  updateEmployee(id:number){
    this.router.navigate(['/employee-update',id]);
  }

  deleteEmployee(id:number) {
    this.router.navigate(['/employee-delete',id]);
  }

}
