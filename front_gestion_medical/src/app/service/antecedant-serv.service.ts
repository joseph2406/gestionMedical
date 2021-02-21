import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Antecedant } from '../model/antecedant';

@Injectable({
  providedIn: 'root'
})
export class AntecedantServService {

  constructor(private httpClient:HttpClient) { }
  host:string="http://localhost:8183/"
  public creerAntecedant(a:Antecedant){
    return this.httpClient.post(this.host+"antecedant",a)}
    public getDescant(cat:string){
      return this.httpClient.get<string[]>(this.host+"antecedant/"+cat)
    }
    public getCategories(){
      return this.httpClient.get<string[]>(this.host+"antecedants")
    }
    public getAntecedants(){
      return this.httpClient.get<Antecedant[]>(this.host+"antecedant")
    }
    public getByDesc(desc:string){
      return this.httpClient.get<Antecedant>(this.host+"antecedantd/"+desc)
    }
    public updateAntecedant(antecedant:Antecedant){
     
      return this.httpClient.put(this.host+"antecedant",(<object>antecedant));
    }


}
