import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {
 id:number;
 employee:Employee = new Employee();
  constructor(private employeeService:EmployeeService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data =>{
     this.employee = data;
     
    },error =>console.log(error));
  }
  onSubmit(){
    this.employeeService.updateEmployee(this.employee).subscribe(data =>{
      this.goToEmployeeList();
    },error =>console.log(error));
  }
  
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

}
