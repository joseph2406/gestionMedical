import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { RDV } from '../model/rdv';

@Injectable({
  providedIn: 'root'
})
export class ParentToChildService {
  private listRdv:BehaviorSubject<any> = new BehaviorSubject<any>(null);

  public setlistRdv(data: any){
      this.listRdv=data
  }
  public getlistRdv(): Observable<any> {
      return this.listRdv.asObservable()
  }
}
