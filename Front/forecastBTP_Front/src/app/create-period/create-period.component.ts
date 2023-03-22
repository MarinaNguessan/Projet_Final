import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { City } from '../models/city';
import { FunctionCityService } from '../services/functionCity';
import { FunctionMeteoService } from '../services/functionMeteo';

@Component({
  selector: 'app-create-period',
  templateUrl: './create-period.component.html',
  styleUrls: ['./create-period.component.css']
})
export class CreatePeriodComponent implements OnInit {

  cities: City[] = [];
  meteos: any;
  load : boolean = false ;
  temp  = new BehaviorSubject("1");
  temp$ = this.temp.asObservable();
  testcloud : any;
  data: any = []
  label: any = []

  constructor(private api : FunctionCityService, private apiMeteo:FunctionMeteoService){

  }

  ngOnInit(){
    this.getAllCity();
    this.getAllMeteo();
  }
  getAllCity(){
    this.api.getCity().subscribe({
      next : (response : any)=>{
        this.cities=response as City[]
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
    this.apiMeteo.getMeteo().subscribe({
      next : (response : any)=>{
        //this.cities=response as any
        console.log(response);
        this.temp.next(response.data[1].temp);

        for(let i=0; i<response.data.length; i++) {
          console.log(response.data[i].precip);
          this.data.push(response.data[i].precip)
          this.label.push(response.data[i].datetime)
        }

        console.log(this.data);
        console.log(this.label)

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
     this.apiMeteo.getMeteo().subscribe({
       next : (response:any)=>{
        this.meteos = response?.data[0]
        this.load = true
        console.log("#####################################")
        console.log(response)
        this.testcloud = this.meteos;
        this.temp.next("5");
     },
     error : (error)=> {
        console.log(error);
     }

    })

  }






}
