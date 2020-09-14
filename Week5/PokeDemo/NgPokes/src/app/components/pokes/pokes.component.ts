import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeService } from 'src/app/services/poke.service';

@Component({
  selector: 'app-pokes',
  templateUrl: './pokes.component.html',
  styleUrls: ['./pokes.component.css']
})
export class PokesComponent implements OnInit {
public poke:Pokemon = null;
public input:number = 0;

  constructor(private ps:PokeService) { }

  ngOnInit(): void {
  }

  getPoke():void {
    this.ps.getPokeFromApi(this.input).subscribe(
      (data)=>{
        this.poke=data;
      },
      () =>{
        this.poke = null;
        console.log("something went wrong");
      }
    )
  }

}
