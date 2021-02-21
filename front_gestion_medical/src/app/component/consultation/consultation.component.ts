import { unescapeIdentifier } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Acte } from 'src/app/model/acte';
import { Antecedant } from 'src/app/model/antecedant';

import { Consultation } from 'src/app/model/consultation';
import { Patient } from 'src/app/model/patient';
import { ActeServService } from 'src/app/service/acte-serv.service';
import { AntecedantServService } from 'src/app/service/antecedant-serv.service';

import { ConsultationServService } from 'src/app/service/consultation-serv.service';
import { PatientServService } from 'src/app/service/patient-serv.service';
import { ToasterService } from 'src/app/service/toaster.service';

@Component({
  selector: 'app-consultation',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.css']
})
export class ConsultationComponent implements OnInit {

  servpatient!:PatientServService
  servcons!:ConsultationServService
  servant!:AntecedantServService
  servacte!:ActeServService
  patient:any=undefined
  public antecedant!: Antecedant;
  categAnt!:string[];
  pantecedants: any[]=[]
  descbyCat!:string[];
  patients:[]=[];
  public actes:any=undefined;
  check:boolean=false;
  checkacte:boolean=false;
  checknew:boolean=false;
  public ncin!:string;
  Lmotif = ["visite de surveillance","visite médicale","Angine","Conjonctivite","Bronchite","Lombalgie","Renouvellement","Gastro-entérite","Douleurs précordiales"]
  c!:Consultation
  a!:Acte
  today: number = Date.now();
  activatedRoute: ActivatedRoute;
  constructor(servacte:ActeServService,servant:AntecedantServService,servpatient:PatientServService,activatedRoute: ActivatedRoute,private toast:ToasterService
    ,private router: Router,servcons:ConsultationServService) { 
    this.servpatient=servpatient
    this.activatedRoute=activatedRoute
    this.servcons=servcons
    this.servant=servant
    this.servacte=servacte
    this.antecedant=new Antecedant(-1,'','',[]);
    this.a=new Acte(-1,'',0,[]);
  }

  ngOnInit(): void {    
    this.trouvePatient(this.activatedRoute.snapshot.params.cin)
    this.selectioncategAntecedant()
    this.allActes() 
 }
 trouvePatient(cin:string){
  this.ncin=cin;
 this.servpatient.getPatientByCin(cin).subscribe(data => {
   this.patient = data;
 }
 , err => { console.log(err); })
 }
 
 onSaveConsultation(data:any){
   let p= new Patient(this.patient.cin,this.patient.nomp,this.patient.prenomp,this.patient.datenaissp,this.patient.datecreaD,
    this.patient.sexep,this.patient.professionp,this.patient.adressep,this.patient.numtelp,
    true);
     this.c=new Consultation(-1,data.motif,data.datecons,data.poids,data.temperature,data.tension,data.perimetre,data.resexamen,p)
      this.servcons.creerConsultation(this.c).subscribe(res => {
        this.ngOnInit();
        setTimeout(() => {
          this.toast.showSuccess("Consultation sauvegardée !");
        }, 100);
      }, err => {
        this.toast.showWarning(err.error.message);
      })
  }
  selectioncategAntecedant(){
    this.servant.getCategories().subscribe(data => {
      this.categAnt= data;
    }
   
    , err => { console.log(err); })
    }
    selectiondescCategAnt(cat:string){
      this.servant.getDescant(cat).subscribe(data => {
        this.descbyCat= data;
      }
      , err => { console.log(err); })
    }
    allActes(){
      this.servacte.getActes().subscribe(data => {
        this.actes= data;
        console.log(this.actes);
        
      }
      , err => { console.log(err); })
    }
    option():void{
      if (this.check==false){
       this.check=true;
      }else{
       this.check=false;
      }      
    }
    option1():void{
      if(this.checknew==false){
        this.checknew=true
      }else{
        this.checknew=false
      }
    }
    option2():void{
      if(this.checkacte==false){
        this.checkacte=true
      }else{
        this.checkacte=false
      }
    }
    onSaveAntecedentPatient(data:any){
      let p= new Patient(this.patient.cin,this.patient.nomp,this.patient.prenomp,this.patient.datenaissp,this.patient.datecreaD,
        this.patient.sexep,this.patient.professionp,this.patient.adressep,this.patient.numtelp,
        true);
      for(let value of data.descant){
        console.log(value);
        this.servant.getByDesc(value).subscribe(data => {   
          data.patients.push(p);
          Object.assign(this.antecedant,data);
          console.log(this.antecedant);
          
          this.servant.updateAntecedant(this.antecedant).subscribe(res => {
            
            this.ngOnInit();
            setTimeout(() => {
              this.toast.showSuccess("Antecedants Ajoutés");
            }, 100);
          }, err => {
            this.toast.showWarning(err.error.message);
          }) 
        }
        , err => { console.log(err); });  
     }        
 }
  
    onSaveActecons(data:any){
      let cons=new Consultation(this.c.numcons,this.c.motif,this.c.datecons,this.c.poids,this.c.temperature,
        this.c.tension,this.c.perimetre,this.c.resexamen,this.c.patient);
      for(let value of data.nameacte){
        console.log(value);
        this.servacte.getacte(value).subscribe(data=>{
          data.consultations.push(cons);
          Object.assign(this.a,data);
          console.log(this.a);

          this.servacte.updateActe(this.a).subscribe(res => {
            
            this.ngOnInit();
            setTimeout(() => {
              this.toast.showSuccess("Actes Ajoutés");
            }, 100);
          }, err => {
            this.toast.showWarning(err.error.message);
          })
          
        }
        , err => { console.log(err);
         });   
    }
  }
    onSaveActe(data:any){   
         Object.assign(this.a,data);
         console.log(this.a);
         
          this.servacte.creerActe(this.a).subscribe(res => {
            this.ngOnInit();
            setTimeout(() => {
              this.toast.showSuccess("Acte sauvegardée !");
            }, 100);
          }, err => {
            this.toast.showWarning(err.error.message);
          })
      }
    }
