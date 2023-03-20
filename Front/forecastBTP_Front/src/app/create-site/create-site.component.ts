import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../services/api.service';
import { VerificationService } from '../services/verification';
import { FunctionSiteService } from '../services/functionSite';
import { Site } from '../models/site';

@Component({
  selector: 'app-create-site',
  templateUrl: './create-site.component.html',
  styleUrls: ['./create-site.component.css']
})
export class CreateSiteComponent {

  sites!:Site
  constructor(private api : FunctionSiteService, private verification : VerificationService, private router :Router){
    this.sites = new Site(null!, null!)

  }

  soumettre(){
    const logVerification  = this.verification.verifyObj(this.sites);
    if(logVerification.count>0){
    console.log(this.sites)
      return alert("Veuillez remplir tout les champs");

    }
      return this.api.postSites(this.sites).subscribe(
        {
          next : (response)=>{
              console.log(response);
              if(!!response) {
                this.router.navigate(["dasboard/createSite"]);
              }else{
                alert("Erreur de creation veuillez contacter le service IT");
              }
          },
          error : (error)=> {
             console.log(error);
          }
        }
      )

    }
  }
