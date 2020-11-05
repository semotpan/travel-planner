import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItineraryNewComponent } from './itinerary-new.component';

describe('ItineraryNewComponent', () => {
  let component: ItineraryNewComponent;
  let fixture: ComponentFixture<ItineraryNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItineraryNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItineraryNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
