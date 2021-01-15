import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientServService {

  constructor(private httpClient:HttpClient) { }
  host:string="http://localhost:5000/"
  errorMsg!: string;
  public getPatient(page:number,size:number){
    /* let Username="medecin"
    let Password="1234"
    const headers=new HttpHeaders({Authorization: 'Basic'+btoa(Username+":"+Password)}) ,{headers,responseType:'text'as'json'}*/
    return this.httpClient.get<Patient[]>(this.host+"patients"+"?page="+page+"&size="+size)
  }
  public creerPatient(p:Patient){
    /* let username="medecin"
    let password="1234"
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) }); */
    return this.httpClient.post(this.host+"patients",p)}
    public getPatientByCin(cin:string){
      return this.httpClient.get<Patient>(this.host+"patients/"+cin)
    }
    public updatePatient(patient:Patient){
      return this.httpClient.put(this.host+"patients",patient)
    }
    public deletePatient(patient:Patient){
      return this.httpClient.put(this.host+"patients",patient)
    }
}
