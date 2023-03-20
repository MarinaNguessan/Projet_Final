import { Component, OnInit } from '@angular/core';
import { City } from '../models/city';
import { FunctionCityService } from '../services/functionCity';
import { FunctionMeteoService } from '../services/functionMeteo';

@Component({
  selector: 'app-create-period',
  templateUrl: './create-period.component.html',
  styleUrls: ['./create-period.component.css']
})
export class CreatePeriodComponent implements OnInit {

  cities: any
  constructor(private api : FunctionCityService, private apiMeteo:FunctionMeteoService){

  }

  ngOnInit(){
    this.getAllCity();
    this.getAllMeteo();
  }
  getAllCity(){
    this.api.getCity().subscribe({
      next : (response)=>{
        this.cities=response
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

  getAllMeteo(){
    this.apiMeteo.getMeteo("Paris,FR&key=609bd5fc7a464644b437c32cb9340a22").subscribe({
      next : (response)=>{
        this.cities=response
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


  changeMeteo(city:any){
    console.log(city.target.value)
     this.apiMeteo.getMeteo(`${city.target.value},CI&key=609bd5fc7a464644b437c32cb9340a22`).subscribe({
       next : (response)=>{
         console.log(response);
         if(!!response) {
         }
     },
     error : (error)=> {
        console.log(error);
     }

    })

  }



}
