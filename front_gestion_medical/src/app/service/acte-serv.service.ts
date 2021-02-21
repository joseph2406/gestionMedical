import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Acte } from '../model/acte';

@Injectable({
  providedIn: 'root'
})
export class ActeServService {

  constructor(private httpClient:HttpClient) { }
  host:string="http://localhost:8183/"
  public creerActe(a:Acte){
    return this.httpClient.post(this.host+"acte",a)}
    public getacte(nom:string){
      console.log(nom);
      
      return this.httpClient.get<Acte>(this.host+"acte/"+nom)
    }
    public getActes(){
      return this.httpClient.get<Acte[]>(this.host+"actes")
    }
    public updateActe(acte:Acte){
     
      return this.httpClient.put(this.host+"acte",(<object>acte));
    }
}
