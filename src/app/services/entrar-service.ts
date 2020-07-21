import { inject } from '@angular/core/testing';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';



@Injectable()
export class EntrarService{

    CriarEntrarUrl= 'http://localhost:4200/api/login/criar';
    LoginUrl= 'http://localhost:4200/api/login';

    constructor(private http: HttpClient, private router:Router){ }


  
    fazerLogin(entrar: any){
        return this.http.post(this.LoginUrl, entrar);
    }

    criarEntrar(entrar: any){
        return this.http.post(this.CriarEntrarUrl, entrar);
    }
}