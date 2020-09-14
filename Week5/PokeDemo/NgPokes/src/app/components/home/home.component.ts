import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public name = 'Harry';
  public value = '';


  constructor() { }

  ngOnInit(): void {
  }

  public mfunc() {
    if(this.name=='Harry'){
      this.name = 'Larry';
    } else {
      this.name = 'Harry';
    }
  }

  public cfunc() {
    document.getElementById('myP').innerText = this.value;
  }

}
