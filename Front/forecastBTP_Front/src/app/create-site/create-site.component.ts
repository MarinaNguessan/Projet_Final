import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../services/api.service';
import { VerificationService } from '../services/verification';

@Component({
  selector: 'app-create-site',
  templateUrl: './create-site.component.html',
  styleUrls: ['./create-site.component.css']
})
export class CreateSiteComponent {

  sites ={
    nom:'',
    description:'',
  }
  constructor(private api : HttpService, private verification : VerificationService, private router :Router){

  }

  soumettre(){
    const logVerification  = this.verification.verifyObj(this.sites);
    if(logVerification.count>= 0)
      return alert("Veuillez remplir tout les champs");


      return this.api.post("register",  this.sites).subscribe(
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
