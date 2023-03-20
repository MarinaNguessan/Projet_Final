import { Injectable } from "@angular/core";
import { Company } from "../models/compagny";
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})
export class FunctionCityService {

  constructor(private httpService : HttpService ) {  }

  setSite(company : Company) {
   return this.httpService.post("api/companies", company);
  }

  updateSite(company : Company) {
    return this.httpService.put({endpoint : "api/companies" , data: company});
  }

  getSites() {
   return this.httpService.get("api/companies");
  }

  postSites(company : Company) {
    return this.httpService.post("api/companies", company);
   }

  deleteSite(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
