import { Component, OnInit } from '@angular/core';
import { TodosService } from '../todos.service';
import { Todo } from '../models/todo';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  constructor(private todoser: TodosService) { }

  visibility:boolean = true;

  todos:Todo[];

  


  ngOnInit(): void {
    this.todoser.getTodos().subscribe(
      (data) => {
        this.todos =data;
        console.log(this.todos);
      }, () => {
        console.log("something went wrong");
      } 
    )
    }
    
  toggleVis(){
    this.visibility = !this.visibility;
  }

}
