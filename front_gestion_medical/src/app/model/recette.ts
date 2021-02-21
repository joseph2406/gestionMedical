import { Consultation } from "./consultation"

export class Recette{
    nummouv!: number
    tarif!: number
    totcons!: number
    consultation!: Consultation
    constructor(num:number,pu:number,tot:number,cons ?: Consultation){
        this.nummouv=num
        this.tarif=pu
        this.totcons=tot
    }
}