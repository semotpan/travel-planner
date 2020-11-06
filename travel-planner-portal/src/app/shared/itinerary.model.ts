import {CityWeather} from './city-weather.model';

export class Itinerary {
  constructor(public name: string, public itineraryMap: CityWeather[]) {
  }
}
