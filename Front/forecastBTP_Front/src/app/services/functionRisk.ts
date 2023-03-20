import { Injectable } from "@angular/core";
import { Risk } from "../models/risk";
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})
export class FunctionRiskService {

  constructor(private httpService : HttpService ) {  }

  setSite(risk : Risk) {
   return this.httpService.post("api/risks", risk);
  }

  updateSite(risk : Risk) {
    return this.httpService.put({endpoint : "api/risks" , data: risk});
  }

  getSites() {
   return this.httpService.get("api/risks");
  }

  postSites(risk : Risk) {
    return this.httpService.post("/api/risks", risk);
   }

  deleteSite(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
