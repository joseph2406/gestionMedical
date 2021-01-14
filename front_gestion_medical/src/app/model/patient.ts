import { Antecedant } from "./antecedant"
import { APCI } from "./apci"
import { CNAM } from "./cnam"
import { RDV } from "./rdv"

export class Patient{
    cin!:string
    nomp!: string
    prenomp!:string
    datenaissp!:Date
    datecreaD!:Date
    sexep!:string
    professionp!:string
    adressep!:string
    numtelp!:string
    valid!: boolean
    rdv!:RDV[]
    apci!:APCI[]
    cnam!:CNAM
    antecedant!:Antecedant[]
    constructor(cin: string, nomp: string, prenomp: string, datenaissp: Date, datecreaD: Date, sexep: string,
        professionp: string, adressep: string, numtelp: string,valid:boolean, rdv ?: RDV[], apci ?: APCI[], cnam ?: CNAM, antecedant ?: Antecedant[]) {
            this.cin=cin
            this.nomp=nomp
            this.prenomp=prenomp
            this.datenaissp=datenaissp
            this.datecreaD=datecreaD
            this.sexep=sexep
            this.professionp=professionp
            this.adressep=adressep
            this.numtelp=numtelp
            this.valid=valid
    }
}