import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";



@Injectable({
  providedIn : 'root'
})
export class FunctionMeteoService {

  constructor(private httpService : HttpClient ) {  }

  getMeteo(){
    //console.log(`https://api.weatherbit.io/v2.0/forecast/daily?city=${endpoint}`);
    //return this.httpService.get(`https://api.weatherbit.io/v2.0/forecast/daily?city=${endpoint}` );
    return this.httpService.get(`/assets/meteo.json`);

  }

}
