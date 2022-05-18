import { EmployeeDeleteComponent } from './employee-delete/employee-delete.component';
import { EmployeeUpdateComponent } from './employee-update/employee-update.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentListComponent } from './department-list/department-list.component';

const routes: Routes = [
  {path:'employees' , component:EmployeeListComponent},
  {path:'departments', component:DepartmentListComponent},
  {path:'employee-create', component:EmployeeCreateComponent},
  {path:'', component:EmployeeListComponent},
  {path:'employee-update/:id', component:EmployeeUpdateComponent},
  {path:'employee-delete/:id',component:EmployeeDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
