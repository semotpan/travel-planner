import {Component, OnInit, ViewChild} from '@angular/core';
import {CityWeather} from '../../shared/city-weather.model';
import {ItineraryMapService} from '../../services/itinerary-map.service';
import {HttpClient} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import {Itinerary} from '../../shared/itinerary.model';

@Component({
  selector: 'app-itinerary-add',
  templateUrl: './itinerary-add.component.html',
  styleUrls: ['./itinerary-add.component.css']

})
export class ItineraryAddComponent implements OnInit {
  @ViewChild('f', {static: true}) form: NgForm;
  citiesWeather: CityWeather [] = [];

  constructor(private itineraryMapService: ItineraryMapService,
              private http: HttpClient) {
  }

  ngOnInit() {
    this.itineraryMapService.currentCityWeather
      .subscribe(cityWeather => {
        if (cityWeather !== null) {
          this.citiesWeather.push(cityWeather);
        }
      });
  }

  onSubmit() {
    this.http.post('http://localhost:8080/itinerary', new Itinerary(this.form.valueOf.name, this.citiesWeather))
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      );
    this.form.reset();
  }
}
