import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/model/patient';
import { PatientServService } from 'src/app/service/patient-serv.service';
import { Router } from '@angular/router';
import { ToasterService } from 'src/app/service/toaster.service';
@Component({
  selector: 'app-nouv-patient',
  templateUrl: './nouv-patient.component.html',
  styleUrls: ['./nouv-patient.component.css'],
})
export class NouvPatientComponent implements OnInit {
  date: Date=new Date();
  datecread: Date=new Date();
  servpatient!: PatientServService;
  p!:Patient
  toast: ToasterService;
  constructor(servpatient:PatientServService,private router: Router, toast:ToasterService) { 
    this.servpatient=servpatient
    this.toast=toast
   }
  ngOnInit(): void {
  }
  onSavePatient(data:any){
  console.log(data)
     this.p=new Patient(data.cin,data.nom,data.prenom,data.datenaiss,
      this.date,data.sexe,data.profession,data.adresse,data.telp,true)
      this.servpatient.creerPatient(this.p).subscribe(res => {
        this.toast.showSuccess("Patient Ajouté avce succée");
        setTimeout(() => {
          this.router.navigateByUrl('/dashboard');
        }, 1000);
      }, err => {
        this.toast.showWarning(err.error.message);
      })
  }
}
