import { Patient } from "./patient";

export class CNAM{
    matcnam: string;
    datedebvalid: Date;
    datefinvalid: Date;
    typecnam:string;
    aff:string;
    patient:Patient;
    constructor(matcnam: string,datedebvalid: Date,datefinvalid: Date,typecnam:string,aff:string,patient:Patient){
        this.matcnam=matcnam;
        this.datedebvalid=datedebvalid;
        this.datefinvalid=datefinvalid;
        this.typecnam=typecnam;
        this.aff=aff;
        this.patient=patient;
    }



}