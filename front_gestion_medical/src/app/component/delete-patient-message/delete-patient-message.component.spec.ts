import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePatientMessageComponent } from './delete-patient-message.component';

describe('DeletePatientMessageComponent', () => {
  let component: DeletePatientMessageComponent;
  let fixture: ComponentFixture<DeletePatientMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletePatientMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletePatientMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
