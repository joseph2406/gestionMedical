import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Antecedant } from '../model/antecedant';
import { AntecedantServService } from '../service/antecedant-serv.service';
import { ToasterService } from '../service/toaster.service';

@Component({
  selector: 'app-nouv-antecedant',
  templateUrl: './nouv-antecedant.component.html',
  styleUrls: ['./nouv-antecedant.component.css']
})
export class NouvAntecedantComponent implements OnInit {
  servAntecedant!: AntecedantServService;
  listAntecedant: any = [];
  ant!:Antecedant
  toast: ToasterService ;
  constructor(servAntecedant:AntecedantServService,private router: Router, toast:ToasterService) { 
    this.servAntecedant=servAntecedant
    this.toast=toast }

  ngOnInit(): void {
    this.getAntecedants()
  }
  saveAntecedant(data:any){
    console.log(data)
       this.ant=new Antecedant(data.idant,data.categant,data.descant)
        this.servAntecedant.creerAntecedant(this.ant).subscribe(res => {
          this.toast.showSuccess("Antecedant Ajouté avce succée");
          setTimeout(() => {
            this.router.navigateByUrl('/dashboard');
          }, 1000);
        }, err => {
          this.toast.showWarning(err.error.message);
        })
    }
    getAntecedants(){
      this.servAntecedant.getAntecedant()
      .subscribe(data=>{
        this.listAntecedant=data
      });
    
    }
}
