import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {CityWeather} from '../shared/city-weather.model';

@Injectable({
  providedIn: 'root'
})
export class ItineraryMapService {

  cityWeatherSource: BehaviorSubject<CityWeather> = new BehaviorSubject<CityWeather>(null);
  currentCityWeather = this.cityWeatherSource.asObservable();

  constructor() { }

  submitItineraryMap(cityWeather: CityWeather) {
    this.cityWeatherSource.next(cityWeather);
  }
}
