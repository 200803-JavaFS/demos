import { Component, OnInit } from '@angular/core';
import { TodosService } from '../todos.service';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  constructor(private todoser: TodosService) { }

  visibility:boolean = true;

  todos:Object[];

  


  ngOnInit(): void {
    this.todos=this.todoser.getTodos();
  }

  toggleVis(){
    this.visibility = !this.visibility;
  }

}
