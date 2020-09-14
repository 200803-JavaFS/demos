import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokesComponent } from './pokes.component';

describe('PokesComponent', () => {
  let component: PokesComponent;
  let fixture: ComponentFixture<PokesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
