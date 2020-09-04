import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodosService {
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



  constructor() { }
  
getTodos(): Object[] {
  
    let todos = [this.todo1, this.todo2, this.todo3, this.todo4];
    return todos;
  }

}
