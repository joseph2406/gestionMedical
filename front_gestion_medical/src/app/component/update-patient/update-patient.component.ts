import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientServService } from 'src/app/service/patient-serv.service';
import { ToasterService } from 'src/app/service/toaster.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
  servpatient!:PatientServService
  patient!:Patient
  patientn!:Patient
  activatedRoute: ActivatedRoute;
  constructor(servpatient:PatientServService,activatedRoute: ActivatedRoute,private toast:ToasterService
    ,private router: Router) { 
    this.servpatient=servpatient
    this.activatedRoute=activatedRoute
  }

  ngOnInit(): void {
   this.trouvePatient(this.activatedRoute.snapshot.params.cin)

}
trouvePatient(cin:string){
this.servpatient.getPatientByCin(cin).subscribe(data => {
  this.patient = data;
}
, err => { console.log(err); })
}
onEditPatient(p:any)
{
  if(p.sexe!=""){
 this.patientn = new Patient(p.cin,p.nom,p.prenom,p.datenaiss,this.patient.datecreaD,
  p.sexe,p.profession,p.adresse,p.telp,true)
 }
 else{
  this.patientn = new Patient(p.cin,p.nom,p.prenom,p.datenaiss,this.patient.datecreaD,
    this.patient.sexep,p.profession,p.adresse,p.telp,true)
 }
  this.servpatient.updatePatient(this.patientn).subscribe(res => {
    this.toast.showSuccess ("Patient Modifié avce succée");
    setTimeout(() => {
      this.router.navigateByUrl('/dashboard');
    }, 1000);
  }, err => {
    this.toast.showWarning(err.error.message);   
    
  })
  console.log(this.patientn)
}
btnCancel(){
  this.router.navigateByUrl('/dashboard');
}
}
