import { TestBed } from '@angular/core/testing';

import { ItineraryMapService } from './itinerary-map.service';

describe('ItineraryMapService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ItineraryMapService = TestBed.get(ItineraryMapService);
    expect(service).toBeTruthy();
  });
});
