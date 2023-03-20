import { Injectable } from "@angular/core";
import { HttpService } from "./api.service";
import { Site } from "../models/site";

@Injectable({
  providedIn : 'root'
})
export class FunctionSiteService {

  constructor(private httpService : HttpService ) {  }

  setSite(site : Site) {
   return this.httpService.post("api/sites", site);
  }

  updateSite(site : Site) {
    return this.httpService.put({endpoint : "api/sites" , data: site});
  }

  getSites() {
   return this.httpService.get("api/sites");
  }

  postSites(site : Site) {
    return this.httpService.post("api/sites/register", site);
   }

  deleteSite(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
