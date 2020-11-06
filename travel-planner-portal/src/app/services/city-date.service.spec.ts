import { TestBed } from '@angular/core/testing';

import { CityDateService } from './city-date.service';

describe('CityDateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CityDateService = TestBed.get(CityDateService);
    expect(service).toBeTruthy();
  });
});
