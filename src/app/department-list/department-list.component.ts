import { DepartmentService } from './../department.service';
import { Component, OnInit } from '@angular/core';
import { Department } from '../deparment.model';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent implements OnInit {
   departments:Department[];
  constructor(private departmentService:DepartmentService) { }

  ngOnInit(): void {
    this.departmentList();
  }
   departmentList() {
     this.departmentService.getDepartmentList().subscribe(data =>{
       this.departments = data;
     })
   }
}
