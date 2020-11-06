import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {CityDate} from '../../shared/city-date.model';
import {CityDateService} from '../../services/city-date.service';

@Component({
  selector: 'app-city-add',
  templateUrl: './city-add.component.html',
  styleUrls: ['./city-add.component.css']
})
export class CityAddComponent implements OnInit {
  @ViewChild('f', {static: true}) form: NgForm;

  constructor(private cityDateService: CityDateService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.cityDateService.submitCity(new CityDate(this.form.value.city, this.form.value.date));
    this.form.reset();
  }
}
