import { Injectable } from "@angular/core";
import { PreventiveAction } from "../models/preventiveAction";
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})
export class FunctionPreventiveService {

  constructor(private httpService : HttpService ) {  }

  setSite(preventive : PreventiveAction) {
   return this.httpService.post("api/preventives", preventive);
  }

  updateSite(preventive : PreventiveAction) {
    return this.httpService.put({endpoint : "api/preventives" , data: preventive});
  }

  getSites() {
   return this.httpService.get("api/preventives");
  }

  postSites(preventive : PreventiveAction) {
    return this.httpService.post("api/preventives", preventive);
   }

  deleteSite(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
