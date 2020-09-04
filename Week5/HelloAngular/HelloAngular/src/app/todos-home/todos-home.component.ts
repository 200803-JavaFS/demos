import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  constructor() { }

  visibility:boolean = true;

  todo1 = {
    id: 1,
    content: "Make a cup of coffee before I practice my Java!",
    status: "Incomplete"
  }

  todo2 = {
    id: 2,
    content: "Merge sort all of my socks before laundry day. P.S. I hate laundry days!",
    status: "Incomplete"
  }

  todo3 = {
    id: 3,
    content: "Feed my pet python a snack.",
    status: "Incomplete"
  }

  todo4 = {
    id: 4,
    content: "Have another cup of coffee before I go rehearse the script for my upcoming play: JavaScript.",
    status: "Incomplete"
  }

  todos = [this.todo1, this.todo2, this.todo3, this.todo4];


  ngOnInit(): void {
  }

  toggleVis(){
    this.visibility = !this.visibility;
  }

}
