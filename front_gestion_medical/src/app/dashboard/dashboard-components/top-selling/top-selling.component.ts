import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DeletePatientMessageComponent } from 'src/app/component/delete-patient-message/delete-patient-message.component';
import { Antecedant } from 'src/app/model/antecedant';
import { APCI } from 'src/app/model/apci';
import { Consultation } from 'src/app/model/consultation';
import { Patient } from 'src/app/model/patient';
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
data:any
verif:boolean=false
checkcons:boolean=false;
checkapci:boolean=false;
checkant:boolean=false;
checkrdv:boolean=false;
p:string='';
servpatient!: PatientServService;
passList:ParentToChildService
patient!:Patient
  public listRdv: RDV[] = [];
  public listAtcd:Antecedant[] = [];
  public listApci:APCI[]=[]
  public listCons:Consultation[]=[]
 private matDialog: MatDialog;
  constructor(servpatient:PatientServService,passList:ParentToChildService,
    private router: Router,protected modalService: NgbModal ,public formBuilder: FormBuilder,  matDialog:MatDialog) { 
    this.servpatient=servpatient;
    this.passList=passList;
    this.matDialog=matDialog;
  }
  
  ngOnInit(): void {
    this.servpatient.getPatient(this.currentPage,this.size)
    .subscribe(data=>{this.patients=data;this.totalElement=data["totalElements"];}
      ,err=>{this.sms = err.error.message;
        this.patients =null;
        })
  }
  loadPatients(){
    this.servpatient.getPatient(0,this.size)
    .subscribe(data=>{this.patients=data;this.totalElement=this.patients["totalElements"];}
      ,err=>{this.sms = err.error.message;
        this.patients =null;
        })
  }
  passerListRdv(list1:RDV[],list2:Antecedant[],list3:APCI[],list4:Consultation[],cin:string){
    this.p=cin
    this.listRdv=list1
     this.listAtcd=list2
     this.listApci=list3
     this.listCons=list4
    if(this.listRdv.length==0){
      this.sms="Pas De Rendez-vous Pour ce Patient"
    }
  }
  onChange(s:number){
    this.page=1
    if(s){
    this.servpatient.getPatient(0,this.size)
    .subscribe(data=>{this.patients=data;this.totalElement=data["totalElements"];}
    ,err=>{this.sms = err.error.message;
      this.patients =null;
      })
    }
  }
  editPatient(cin:string){
    this.router.navigateByUrl("/Updatepatient/"+cin);
  }
  onPageChange(i:number)
  {
this.currentPage=i-1
this.page=this.currentPage+1
this.ngOnInit()
  }
  deletePatient(cin :string): void {
   // let patient=new Patient(p.cin,p.nomp,p.prenomp,p.datenaissp,p.datecreaD,p.sexep,p.professionp,p.adressep,
     // p.numtelp,false)
    this.servpatient.getPatientByCin(cin).subscribe(data=>{this.patient=data;console.log(this.patient)
     const dialogConfig=this.matDialog.open(DeletePatientMessageComponent , 
     {width:"50%",
     disableClose:true,
     autoFocus:true,
     data:{patient:this.patient}
     } );
     dialogConfig.afterClosed().subscribe((result) => {
      this.loadPatients();
    });})
   }
   optioncons():void{
     if (this.checkcons==false){
      this.checkcons=true;
     }else{
      this.checkcons=false;
     }
    
   }
   optionapci():void{
    if (this.checkapci==false){
     this.checkapci=true;
    }else{
     this.checkapci=false;
    }
   
  }
  optionant():void{
    if (this.checkant==false){
     this.checkant=true;
    }else{
     this.checkant=false;
    }
  }
  optionrdv():void{
    if (this.checkrdv==false){
     this.checkrdv=true;
    }else{
     this.checkrdv=false;
    }
  }
  passerVersConsultation(){  
    this.router.navigateByUrl("/Nconsultation/"+this.p);
  }
}
