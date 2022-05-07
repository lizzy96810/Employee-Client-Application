import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {
  id:number;
  constructor(private employeeService:EmployeeService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.deleteEmployee(this.id).subscribe(data =>{
    this.goToEmployeeList(); 
    })
  }
  
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

}
