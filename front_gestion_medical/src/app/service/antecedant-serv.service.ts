import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Antecedant } from '../model/antecedant';

@Injectable({
  providedIn: 'root'
})
export class AntecedantServService {
  host: string = "http://localhost:5000/"
  constructor(private httpClient: HttpClient) { }
  errorMsg!: string;
  public getAntecedant() {

    return this.httpClient.get<Antecedant[]>(this.host + "antecedant")
  }
  public creerAntecedant(ant: Antecedant) {

    return this.httpClient.post(this.host + "antecedant", ant)
  }

  public getAntecedantById(id: number) {
    return this.httpClient.get<Antecedant>(this.host + "antecedant/" + id)
  }
  public updateAntecedant(antecedant: Antecedant) {
    return this.httpClient.put(this.host + "antecedant", antecedant)
  }
  public deleteAntecedant(id: string) {
    return this.httpClient.delete(this.host + "antecedant/"+id)
  }


}
