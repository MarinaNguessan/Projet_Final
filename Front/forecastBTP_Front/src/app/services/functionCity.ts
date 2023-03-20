import { Injectable } from "@angular/core";
import { HttpService } from "./api.service";
import { City } from "../models/city";

@Injectable({
  providedIn : 'root'
})
export class FunctionCityService {

  constructor(private httpService : HttpService ) {  }

  setCity(city : City) {
   return this.httpService.post("api/cities", city);
  }

  updateCity(city : City) {
    return this.httpService.put({endpoint : "api/cities" , data: city});
  }

  getCity() {
   return this.httpService.get("api/cities");
  }

  postCity(city : City) {
    return this.httpService.post("api/cities", city);
   }

  deleteCity(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
