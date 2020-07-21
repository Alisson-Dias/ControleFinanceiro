import { CategoriaComponent } from './../pages/categoria/categoria.component';
import { element } from 'protractor';
import { Component,ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';


@Component({
    selector: 'app-layout',
    templateUrl: './layout.full.component.html',
  styleUrls: ['./layout.full.component.scss'],
  encapsulation: ViewEncapsulation.None


})

export class LayoutAlisson {
    constructor(private routes: Router){

    }
    
    botaoSair(){
     
      console.log("saiu");
      
      sessionStorage.clear();

     this.routes.navigate(['/entrar']);
  };
}

  