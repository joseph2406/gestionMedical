import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CNAM } from '../model/cnam';

@Injectable({
  providedIn: 'root'
})
export class CnamServService {

  host: string = "http://localhost:5000/"
  constructor(private httpClient: HttpClient) { }
  errorMsg!: string;
  public getCnam() {

    return this.httpClient.get<CNAM[]>(this.host + "cnam")
  }
  public creerCnam(cnam: CNAM) {

    return this.httpClient.post(this.host + "cnam", cnam)
  }

  public getCnamById(mat: number) {
    return this.httpClient.get<CNAM>(this.host + "cnam/" + mat)
  }
  public updateCnam(cnam: CNAM) {
    return this.httpClient.put(this.host + "cnam", cnam)
  }
  public deleteCnam(mat: string) {
    return this.httpClient.delete(this.host + "cnam/"+mat)
  }

}
