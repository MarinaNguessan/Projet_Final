import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreventiveActionComponent } from './preventive-action.component';

describe('PreventiveActionComponent', () => {
  let component: PreventiveActionComponent;
  let fixture: ComponentFixture<PreventiveActionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreventiveActionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreventiveActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
