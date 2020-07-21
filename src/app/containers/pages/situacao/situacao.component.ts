import { TotalService } from './../../../services/total-service';
import { Component,OnInit } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';



@Component({
 selector: 'app-situacao',
 templateUrl: './situacao.component.html'
})

export class SituacaoComponent implements OnInit {
    
    
    id = sessionStorage.getItem('id');
    
    total: any = {};
   
    constructor(private totalService: TotalService, private route: ActivatedRoute, private routes: Router) { } 
    
    ngOnInit(){
        
        if(this.id == null){
            this.routes.navigate(['/entrar']);
        }
        this.id;
        this.listarTotal();
       
    }
    listarTotal(){
        this.totalService.listarTotal(this.id).subscribe(dados => { 
            this.total = dados;
            
        });
    }    
}
 



