import { Component, OnInit } from '@angular/core';
import { Antecedant } from 'src/app/model/antecedant';
import { APCI } from 'src/app/model/apci';
import { RDV } from 'src/app/model/rdv';
import { ParentToChildService } from 'src/app/service/parent-to-child.service';
import { PatientServService } from 'src/app/service/patient-serv.service';

@Component({
  selector: 'app-top-selling',
  templateUrl: './top-selling.component.html',
  styleUrls: ['./top-selling.component.css']
})
export class TopSellingComponent implements OnInit {
//topSelling!: Product[];
errorMessage!: string;
public size:number=5
public page:number=1
public currentPage:number=0
public totalElement!: number;
public patients:any=undefined;
sms: any;
verif:boolean=false
servpatient!: PatientServService;
passList:ParentToChildService
  public listRdv: RDV[] = [];
  public listAtcd:Antecedant[] = [];
  public listApci:APCI[]=[]

  constructor(servpatient:PatientServService,passList:ParentToChildService) { 

    //this.topSelling=TopSelling;
    this.servpatient=servpatient;
    this.passList=passList;
  }
  
  ngOnInit(): void {
    this.loadPatients()
  }
  loadPatients(){
    this.servpatient.getPatient(this.currentPage,this.size)
    .subscribe(data=>{this.patients=data;this.totalElement=this.patients["totalElements"];}
      ,err=>{this.sms = err.error.message;
        this.patients =null;
        })
  }
  passerListRdv(list1:RDV[],list2:Antecedant[],list3:APCI[]){
     this.listRdv=list1
     this.listAtcd=list2
     this.listApci=list3
    if(this.listRdv.length==0){
      this.sms="Pas De Rendez-vous Pour ce Patient"
    }
  }

}
