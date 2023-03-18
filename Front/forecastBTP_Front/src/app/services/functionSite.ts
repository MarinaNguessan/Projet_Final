import { Injectable } from "@angular/core";
import { HttpService } from "./api.service";
import { Site } from "../models/site.model";

@Injectable({
  providedIn : 'root'
})
export class FunctionSiteService {

  constructor(private httpService : HttpService ) {  }

  setSite(site : Site) {
   return this.httpService.post("/sites", site);
  }

  updateSite(site : Site) {
    return this.httpService.put({endpoint : "/sites" , data: site});
  }

  getSites() {
   return this.httpService.get("/sites");
  }

  postSites(site : Site) {
    return this.httpService.post("/sites", site);
   }

  deleteSite(id : string) {
    return this.httpService.delete(`delete/${id}`);
  }



}
