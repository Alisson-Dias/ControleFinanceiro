
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class RendaService{

    Url = 'http://localhost:4200/api/renda';

    constructor(private http: HttpClient){ }

    listarRenda(){
        return this.http.get<any[]>(`${this.Url}`);
    }
    criarRenda(renda: any){
        return this.http.post(this.Url, renda);
    }
}
