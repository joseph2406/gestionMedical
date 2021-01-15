import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouvAntecedantComponent } from './nouv-antecedant.component';

describe('NouvAntecedantComponent', () => {
  let component: NouvAntecedantComponent;
  let fixture: ComponentFixture<NouvAntecedantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NouvAntecedantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NouvAntecedantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
