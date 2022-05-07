import { Employee } from './employee.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  baseUrl= "http://localhost:8080/employee/";
  constructor(private http:HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
   return this.http.get<Employee[]>(this.baseUrl + `all`);
  }

  saveEmployee(employee:Employee): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl + `save`,employee);
  }

  getEmployeeById(id:number): Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl + `find/${id}`);
  }

  updateEmployee(employee:Employee): Observable<Object> {
    return this.http.put(this.baseUrl + `update`,employee);
  }

  deleteEmployee(id:number): Observable<Object>{
    return this.http.delete(this.baseUrl + `delete/${id}`);
  }
}
