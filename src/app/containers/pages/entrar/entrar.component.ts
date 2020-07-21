import { element } from 'protractor';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { getTestBed } from '@angular/core/testing';
import { HttpErrorResponse } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { EntrarService } from './../../../services/entrar-service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { analyzeAndValidateNgModules } from '@angular/compiler';



@Component({
    selector: 'app-entrar',
    templateUrl: './entrar.component.html'
})

export class EntrarComponent implements OnInit{
   
    id = sessionStorage.getItem('id');

   
    entrar: any;
    router: any;
    listarErro: any ;
    listarErros: any =[];
   

    constructor(private entrarService: EntrarService,private routes: Router){ }
    
    ngOnInit(): void {
        if(this.id != null){
            this.routes.navigate(['/categoria']);
        }
        this.entrar = {};
    }
   
    criarEntrar(){
        this.entrarService.criarEntrar(this.entrar).subscribe( (response: any) =>{

                sessionStorage.setItem('id', response.id);

                this.routes.navigate(['/categoria']);
        
            },
             erro =>{
             
                var filtro = erro.error.errors
            
                for (let i = 0; i < filtro.length; i++) {
                    const erros = filtro[i].message;
                    this.listarErros.push(erros);
                }
         
            }
        );
    };
    fazerLogin(){
        this.entrarService.fazerLogin(this.entrar).subscribe( (response: any) => {
            
            console.log('response', response)
            
            sessionStorage.setItem('id',  response.id);

            this.routes.navigate(['/categoria']);
        

        }, erro=>{
            
         
            var filtro = erro.error.errors
            
            for(let i =0; i < filtro.length; i++){
                const erros = filtro[i].message;
                this.listarErros.push(erros);
            }
        });
    }
}