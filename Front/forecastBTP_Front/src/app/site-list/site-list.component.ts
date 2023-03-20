import { Component } from '@angular/core';
import { FunctionSiteService } from '../services/functionSite';

@Component({
  selector: 'app-site-list',
  templateUrl: './site-list.component.html',
  styleUrls: ['./site-list.component.css']
})
export class SiteListComponent {

  sites:any
  constructor(private api : FunctionSiteService){

  }

  ngOnInit(){
    this.getListSites();
  }
  getListSites(){
    this.api.getSites().subscribe({
      next : (response)=>{
        this.sites=response
        console.log(response);
        if(!!response) {
        }else{
          alert("Erreur de creation veuillez contacter le service IT");
        }
    },
    error : (error)=> {
       console.log(error);
    }

    })
  }





}

