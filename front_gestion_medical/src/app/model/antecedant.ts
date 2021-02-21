import { Patient } from "./patient";

export class Antecedant{
  
    constructor(public idant:number,public categant:string='',public descant:string='',
    public patients: any[]=[]){}
}