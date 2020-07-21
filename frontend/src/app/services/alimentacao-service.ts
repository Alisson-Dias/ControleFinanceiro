import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class AlimentacaoService{

    alimentacaoUrl = 'http://localhost:4200/api/alimentacao';
  
    
    constructor(private http: HttpClient){ }

    listarAlimentacao(){
        return this.http.get<any[]>(`${this.alimentacaoUrl}`);
    }
    criarAlimentacao(alimentacao: any){
        return this.http.post(this.alimentacaoUrl, alimentacao);
    }
}

