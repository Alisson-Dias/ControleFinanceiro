import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class TotalService{

    totalUrl = 'http://localhost:4200/api/totalRenda';

    constructor(private http: HttpClient){ }
   
    
    
    
    listarTotal(id: any){
        return this.http.get<any>(`${this.totalUrl}/${id}`);
    }
}

