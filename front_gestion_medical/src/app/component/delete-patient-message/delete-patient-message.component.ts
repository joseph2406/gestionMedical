import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialog,MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Patient } from 'src/app/model/patient';
import { PatientServService } from 'src/app/service/patient-serv.service';
import { ToasterService } from 'src/app/service/toaster.service';

@Component({
  selector: 'app-delete-patient-message',
  templateUrl: './delete-patient-message.component.html',
  styleUrls: ['./delete-patient-message.component.css']
})
export class DeletePatientMessageComponent implements OnInit {
  servpat!: PatientServService;
  public dialogRef!:MatDialogRef<DeletePatientMessageComponent>
  private toasterService !:ToasterService
  constructor(servpat:PatientServService,  dialogRef:MatDialogRef<DeletePatientMessageComponent>,
      toasterService :ToasterService,
    @Optional() @Inject(MAT_DIALOG_DATA) public data:any) { 
      this.toasterService=toasterService
      this.dialogRef=dialogRef
      this.servpat=servpat
    }

  ngOnInit(): void {
  }
  confirmDelete(p:Patient): void {
    let patient= new Patient(p.cin,p.nomp,p.prenomp,p.datenaissp,p.datecreaD,p.sexep,
      p.professionp,p.adressep,p.numtelp,false)
     console.log(patient)
    this.servpat.deletePatient(patient).subscribe(() => {
        this.toasterService.showSuccess("le Patient "+patient.prenomp+ " a été supprimer avec succés");
        this.dialogRef.close();
      
    });
  }
  close(){
    this.dialogRef.close()
  }
}
