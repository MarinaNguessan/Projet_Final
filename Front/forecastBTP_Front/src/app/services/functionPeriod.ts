import { Injectable } from "@angular/core";
import { Period } from "../models/period";
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})
export class FunctionPeriodService {

  constructor(private httpService : HttpService ) {  }

  setPeriod(period : Period) {
   return this.httpService.post("api/period", period);
  }

  updatePeriod(period : Period) {
    return this.httpService.put({endpoint : "api/period" , data: period});
  }

  getPeriod() {
   return this.httpService.get("api/period");
  }

  postPeriod(period : Period) {
    return this.httpService.post("api/period", period);
   }

  deletePeriod(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
