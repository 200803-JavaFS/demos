import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PokesComponent } from './components/pokes/pokes.component';

const routes: Routes = [{
  path:'home',
  component:HomeComponent
},
{
  path: '',
  component: HomeComponent
},
{
  path:'pokemon',
  component:PokesComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
