import { EmployeeService } from './../employee.service';
import { Employee } from './../employee.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employee: Employee = new Employee();
  constructor(private employeeService:EmployeeService,
              private router:Router) { }

  ngOnInit(): void {
  }
  saveEmployee(){
    this.employeeService.saveEmployee(this.employee).subscribe(data =>{
      this.employee =data;
      console.log(this.employee);
      this.goToEmployeeList();
    },error =>console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
