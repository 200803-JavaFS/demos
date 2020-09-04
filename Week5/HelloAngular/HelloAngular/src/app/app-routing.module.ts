import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TodosHomeComponent } from './todos-home/todos-home.component';
import { GreetingComponent } from './greeting/greeting.component';

const routes: Routes = [
  {
    path:"todos",
    component: TodosHomeComponent
  },
  {
    path:"hello",
    component:GreetingComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
