
import { Patient } from "./patient"


export class Consultation{
    numcons!: number
    motif!: string
    datecons!:Date
    poids!: number
    temperature!: number
    tension!: number
    perimetre!: number
    resexamen!: string
    public patient:any=undefined
    constructor(num:number,motif:string,datecons:Date,poid:number,temp:number,tension:number,per:number,
        resexamen:string, patient ?: Patient)
        {
            this.numcons=num
            this.motif=motif
            this.datecons=datecons
            this.poids=poid
            this.temperature=temp
            this.tension=tension
            this.perimetre=per
            this.resexamen=resexamen
            this.patient=patient
        }
}