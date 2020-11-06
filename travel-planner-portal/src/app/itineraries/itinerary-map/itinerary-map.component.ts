import {Component, OnInit} from '@angular/core';
import {CityDateService} from '../../services/city-date.service';
import {CityDate} from '../../shared/city-date.model';
import {HttpClient, HttpParams} from '@angular/common/http';
import {CityWeather} from '../../shared/city-weather.model';
import {ItineraryMapService} from '../../services/itinerary-map.service';

@Component({
  selector: 'app-itinerary-map',
  templateUrl: './itinerary-map.component.html',
  styleUrls: ['./itinerary-map.component.css']
})
export class ItineraryMapComponent implements OnInit {
  cityDates: CityDate[] = [];
  citiesWeather: CityWeather [] = [];

  constructor(private cityDateService: CityDateService,
              private itineraryMapService: ItineraryMapService,
              private http: HttpClient) {
  }

  ngOnInit() {
    this.cityDateService.currentCityDate
      .subscribe(cityDate => {
        if (cityDate !== null) {
          this.cityDates.push(cityDate);
          this.http.post('http://localhost:8080/submit-city', cityDate)
            .subscribe(
              (response) => this.queryData(cityDate),
              (error) => console.log(error)
            );
        }
      });
  }

  private queryData(cityDate: CityDate) {
    const params = new HttpParams()
      .set('city', cityDate.city)
      .set('date', cityDate.date.toString());
    this.http.get<CityWeather>('http://localhost:8080/weather', {params})
      .subscribe(
        (responseData) => {
          this.citiesWeather.push(responseData);
          this.itineraryMapService.submitItineraryMap(responseData);
        },
        (error) => console.log(error)
      );
  }
}
