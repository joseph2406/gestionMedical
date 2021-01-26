import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CNAM } from 'src/app/model/cnam';
import { Patient } from 'src/app/model/patient';
import { CnamServService } from 'src/app/service/cnam-serv.service';
import { ToasterService } from 'src/app/service/toaster.service';

@Component({
  selector: 'app-cnam',
  templateUrl: './cnam.component.html',
  styleUrls: ['./cnam.component.css']
})
export class CnamComponent implements OnInit {
  servCnam!: CnamServService;
  listCNAM: any = [];
  matcnam!: string;
    datedebvalid!: Date;
    datefinvalid!: Date;
    typecnam!:string;
    affiliation!:string;
    patient!:Patient;
  click: any = "saveCnam(f.value)"
  action: any = true
  cnam!: CNAM
  toast: ToasterService;
  constructor(servCnam: CnamServService, private router: Router, toast: ToasterService) {
    this.servCnam = servCnam
    this.toast = toast
  }

  ngOnInit(): void {
this.action=true;

    this.getCnams()
  }
  saveCnam(data: any) {
    console.log(data)
    this.cnam = new CNAM(data.matcnam,data.datedebvalid,data.datefinvalid,data.typecnam,data.affiliation,data.patient)
    this.servCnam.creerCnam(this.cnam).subscribe(res => {
      this.toast.showSuccess("Carnet cnam Ajouté avce succée");
      setTimeout(() => {
        this.getCnams()
      }, 1000);
    }, err => {
      this.toast.showWarning("maricule existante");
    })
  }
  getCnams() {
    this.servCnam.getCnam()
      .subscribe(data => {
        this.listCNAM = data
      });

  }
  deleteCnam(mat) {
    this.servCnam.deleteCnam(mat)
      .subscribe(() => {
        this.listCNAM = this.listCNAM.filter(c => c.mat)
        this.toast.showSuccess
        this.getCnams()
      })
  }
  miseAJour(c) {
    this.cnam=c;
    this.datedebvalid=c.datedebvalid;
    this.datefinvalid=c.datefinvalid;
    this.typecnam=c.typecnam;
    this.affiliation=c.aff;
    this.matcnam=c.matcnam;
    this.action = false;
  }
 updateCnam(){
  this.cnam.datedebvalid=this.datedebvalid
  this.cnam.datefinvalid=this.datefinvalid
  this.cnam.aff=this.affiliation
  this.cnam.typecnam=this.typecnam
   this.servCnam.updateCnam(this.cnam)
   .subscribe(antecedant=>{
this.action=true
this.matcnam=""
   })
 }
}
