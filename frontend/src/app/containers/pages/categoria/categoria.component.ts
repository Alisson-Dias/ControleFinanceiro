import { MoradiaService } from './../../../services/moradia-service';
import { TransporteService } from './../../../services/transporte-service';
import { AlimentacaoService } from 'src/app/services/alimentacao-service';
import { Component, OnInit } from "@angular/core";
import { RendaService } from 'src/app/services/valor-service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-categoria',
    templateUrl: './categoria.component.html'
})
export class CategoriaComponent  implements OnInit  {
  
    //Moradia
    public valorAluguel: boolean = false;
    public valorCondominio: boolean = false;
    public valorContaLuz: boolean = false;
    public valorContaAgua: boolean = false;
    public valorGas: boolean = false;
    public valorIptu: boolean = false;
    public valorTelefone: boolean = false;
    public valorTelefoneCelular: boolean = false;
    public valorConserto: boolean = false;
    //Alimentação
    public valorRestaurante: boolean = false;
    public valorSupermercado: boolean = false;
    public valorBarLanche: boolean = false;
    //Transporte
    public valorTransportePrivado: boolean = false;
    public valorCombustivel: boolean = false;
    public valorTransportePublico: boolean = false;  
    //Renda
    public valorRenda: boolean = false;

    id = sessionStorage.getItem('id');

        router: any;

        moradia: any;
        moradias: Array<any>;

        transporte: any;
        transportes: Array<any>;

        alimentacoes: Array<any>;
        alimentacao: any;

        rendas: Array<any>;
        renda: any;
  
         formCategoria: any;

    constructor(private alimentacaoService: AlimentacaoService, private transporteService: TransporteService, 
        private moradiaService: MoradiaService, private rendaService: RendaService, private routes: Router) { 
        } 
        
    ngOnInit(){
 
        if(this.id == null){
            this.routes.navigate(['/entrar']);
        }
        
        this.alimentacao = {};   
        this.listarAlimentacao();
        
        this.transporte={};
        this.listarTrasporte();

        this.moradia ={};
        this.listarMoradia();

        this.renda ={};
        this.listarRenda();    
    }
  
    listarAlimentacao(){
        this.alimentacaoService.listarAlimentacao().subscribe(dados => {
          var filtro = dados.filter(e => e.id+"" === this.id);
            
            if(filtro.length > 0){
                this.alimentacao = filtro[0];
            } else {
                this.alimentacao = {};
            }

           if( this.alimentacao.valorRestaurante > 0 ){
            this.valorRestaurante = true
           }if( this.alimentacao.valorBarLanche > 0){
            this.valorBarLanche = true
           }if(this.alimentacao.valorSupermercado > 0){
            this.valorSupermercado = true
           }
            });
      }    
   
      criarAlimentacao() {
        this.alimentacao.pessoaModel ={
            id:sessionStorage.getItem('id')
        }
        this.alimentacaoService.criarAlimentacao(this.alimentacao).subscribe(
            res =>{
                console.log("Salvo Alimentação")
            },
            err =>{
                console.error(err);
            }
        );
    };
    
    listarTrasporte(){
        this.transporteService.listarTransporte().subscribe(dados => {
            var filtro = dados.filter(e => e.id+"" === this.id);
            
            if(filtro.length > 0){
                this.transporte = filtro[0];
            } else {
                this.transporte = {};
            }
            if(this.transporte.valorTransportePrivado > 0){
                this.valorTransportePrivado = true
            }if(this.transporte.valorCombustivel > 0){
                this.valorCombustivel = true
            }if (this.transporte.valorTransportePublico > 0){
                this.valorTransportePublico = true 
            }
        });
    }
    criarTransporte(){
        this.transporte.pessoaModel ={
            id:sessionStorage.getItem('id')
        }
        this.transporteService.criarTransporte(this.transporte).subscribe(
            res =>{
                console.log("Salvo Transporte")
            },
            err =>{
                console.error(err);
            }
        );
    };

    listarMoradia(){
        this.moradiaService.listarMoradia().subscribe(dados =>{
            var filtro = dados.filter(e => e.id+"" === this.id);
            
            if(filtro.length > 0){
                this.moradia = filtro[0];
            } else {
                this.moradia = {};
            }
            if(this.moradia.valorAluguel > 0){
                this.valorAluguel = true
            }if(this.moradia.valorCondominio > 0){
                this.valorCondominio = true
            }if(this.moradia.valorContaLuz > 0){
                this.valorContaLuz = true
            }if(this.moradia.valorContaAgua > 0){
                this.valorContaAgua = true 
            }if(this.moradia.valorGas > 0){
                this.valorGas = true
            }if(this.moradia.valorIptu > 0){
                this.valorIptu = true
            }if(this.moradia.valorTelefone > 0){
                this.valorTelefone = true
            }if(this.moradia.valorTelefoneCelular > 0){
                this.valorTelefoneCelular = true
            }if(this.moradia.valorConserto > 0){
                this.valorConserto = true
            }
        });
    }
    criarMoradia(){
        this.moradia.pessoaModel ={
            id:sessionStorage.getItem('id')
        }
        this.moradiaService.criarMoradia(this.moradia).subscribe(
            res =>{
                console.log("Salvo Moradia")
            },
            err =>{
                console.error(err);
            }
        );
    };
    listarRenda(){
        this.rendaService.listarRenda().subscribe(dados =>{

            var filtro = dados.filter(e => e.id+"" === this.id);
            
            if(filtro.length > 0){
                this.renda = filtro[0];
            } else {
                this.renda = {};
            }
            
            if(this.renda.valorRenda > 0){
                this.valorRenda = true
            
            }
        });
    }
    criarRenda(){
        console.log(this.renda)
        this.renda.pessoaModel ={
            id:sessionStorage.getItem('id')
        }
        this.rendaService.criarRenda(this.renda).subscribe(
            res =>{

                console.log("Salvo renda")
            },
            err =>{
                console.error(err);
            }
        );
    };

    botoesSalvar(){
        
        
        this.criarRenda();   
        
        this.criarMoradia();
        
        this.criarTransporte();
        
        this.criarAlimentacao();

        this.routes.navigate(['/situacao/:id']);
    };

}

