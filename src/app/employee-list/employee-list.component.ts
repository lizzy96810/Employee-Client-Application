import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees:Employee[]
  constructor(private employeeService:EmployeeService,
              private router:Router) { }

  ngOnInit(): void {
    this.getEmployees();
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
