import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
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
  categant: any;
  descant: any;
  click: any = "saveAntecedant(f.value)"
  action: any = true
  ant!: Antecedant
  toast: ToasterService;
  constructor(servAntecedant: AntecedantServService, private router: Router, toast: ToasterService) {
    this.servAntecedant = servAntecedant
    this.toast = toast
  }

  ngOnInit(): void {
this.action=true;

    this.getAntecedants()
  }
  saveAntecedant(data: any) {
    console.log(data)
    this.ant = new Antecedant(data.idant, data.categant, data.descant)
    this.servAntecedant.creerAntecedant(this.ant).subscribe(res => {
      this.toast.showSuccess("Antecedant Ajouté avce succée");
      setTimeout(() => {
        this.categant = ""
        this.descant = ""
        this.getAntecedants()
      }, 1000);
    }, err => {
      this.toast.showWarning("antecedant existe déja");
    })
  }
  getAntecedants() {
    this.servAntecedant.getAntecedant()
      .subscribe(data => {
        this.listAntecedant = data
      });

  }
  deleteAntecedant(id) {
    this.servAntecedant.deleteAntecedant(id)
      .subscribe(() => {
        this.listAntecedant = this.listAntecedant.filter(antecedant => antecedant.id)
        this.toast.showSuccess
        this.getAntecedants()
      })
  }
  miseAJour(antecedant) {
    this.ant = antecedant;
    this.ant.categant=antecedant.categant;
     this.categant = antecedant.categant;
    this.descant = antecedant.descant; 
    this.action = false;
  }
 updateAntecedant(){
  this.ant.categant=this.categant
  this.ant.descant=this.descant
   this.servAntecedant.updateAntecedant(this.ant)
   .subscribe(antecedant=>{
    this.descant=""
    this.categant=""
this.action=true
   })
 }
}
