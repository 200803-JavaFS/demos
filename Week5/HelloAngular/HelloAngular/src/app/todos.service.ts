import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from './models/todo';

@Injectable({
  providedIn: 'root'
})
export class TodosService {




  constructor(private http:HttpClient) { }
  
getTodos(): Observable<Todo[]> {
  
    return this.http.get("http://34.82.182.44/todos") as Observable<Todo[]>;
  }

}
