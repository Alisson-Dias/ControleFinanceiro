
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class TransporteService{

    Url = 'http://localhost:4200/api/transporte';

    constructor(private http: HttpClient){ }

    listarTransporte(){
        return this.http.get<any[]>(`${this.Url}`);
    }
    criarTransporte(transporte: any){
        return this.http.post(this.Url, transporte);
    }
}
