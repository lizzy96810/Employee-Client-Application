import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from './deparment.model';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
 private baseUrl= "http://localhost:8080/deparment/"
  constructor(private http:HttpClient) { }
   
  getDepartmentList(): Observable<Department[]> {
    return this.http.get<Department[]>(this.baseUrl + `all`);
  }
}
