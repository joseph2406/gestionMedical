import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Consultation } from '../model/consultation';
import { Patient } from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class ConsultationServService {

  constructor(private httpClient:HttpClient) { }
  host:string="http://localhost:8183/"
  public creerConsultation(c:Consultation){
    return this.httpClient.post(this.host+"consultation",c)}
    public getConsultation(num:number){
      return this.httpClient.get<Consultation>(this.host+"consultation/"+num)
    }
    public updateConsultation(c:Consultation){
      return this.httpClient.put(this.host+"consultation",c)
    }
    public deleteConsultation(num:number){
      return this.httpClient.delete(this.host+"consultation"+num)
    }
}
