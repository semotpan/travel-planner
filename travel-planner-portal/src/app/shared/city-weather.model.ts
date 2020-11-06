import DateTimeFormat = Intl.DateTimeFormat;

export class CityWeather {
  constructor(public cityName: string, public countryCode: string,
              public temperature: number, public temperatureUnit: string,
              public clouds: number, public cloudsUnit: string,
              public weatherDateTime: DateTimeFormat) {
  }
}
