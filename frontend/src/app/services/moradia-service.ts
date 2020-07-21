import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class MoradiaService{

    moradiaUrl = 'http://localhost:4200/api/moradia';
  
    
    constructor(private http: HttpClient){ }

    listarMoradia(){
        return this.http.get<any[]>(`${this.moradiaUrl}`);
    }
    criarMoradia(moradia: any){
        return this.http.post(this.moradiaUrl, moradia);
    }
}

