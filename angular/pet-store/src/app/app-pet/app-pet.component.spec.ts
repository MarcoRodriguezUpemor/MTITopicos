import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPetComponent } from './app-pet.component';

describe('AppPetComponent', () => {
  let component: AppPetComponent;
  let fixture: ComponentFixture<AppPetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppPetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
