import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CitiesComponent } from './cities/cities.component';
import { CityAddComponent } from './cities/city-add/city-add.component';
import { ItinerariesComponent } from './itineraries/itineraries.component';
import { ItineraryAddComponent } from './itineraries/itinerary-add/itinerary-add.component';
import { ItineraryNewComponent } from './itineraries/itinerary-new/itinerary-new.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ItineraryMapComponent } from './itineraries/itinerary-map/itinerary-map.component';


@NgModule({
  declarations: [
    AppComponent,
    CitiesComponent,
    CityAddComponent,
    ItinerariesComponent,
    ItineraryAddComponent,
    ItineraryNewComponent,
    HeaderComponent,
    FooterComponent,
    ItineraryMapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
