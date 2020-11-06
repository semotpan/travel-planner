import { Injectable } from '@angular/core';
import {CityDate} from '../shared/city-date.model';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityDateService {

  cityDateSource: BehaviorSubject<CityDate> = new BehaviorSubject<CityDate>(null);
  currentCityDate = this.cityDateSource.asObservable();

  constructor() { }

  submitCity(cityDate: CityDate) {
    this.cityDateSource.next(cityDate);
  }
}
