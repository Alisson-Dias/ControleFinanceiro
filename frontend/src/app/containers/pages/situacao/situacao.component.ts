import { TotalService } from './../../../services/total-service';
import { Component,OnInit } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import Chart from 'chart.js';

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

        this.mostrarGraficoRadar();
        this.mostrarGrafico();
    }
    listarTotal(){
        this.totalService.listarTotal(this.id).subscribe(dados => { 
            this.total = dados;
        });
    }    
    mostrarGrafico(){
        this.totalService.listarTotal(this.id).subscribe(dados => { 
            this.total = dados;
            
            var div = document.getElementById('chart-container');
            var canvas = document.createElement('CANVAS')
            canvas.style.height = '100px'
            canvas.id = 'chart-canvas'

            div.appendChild(canvas)
            
            var ctx = document.getElementById('chart-canvas')
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Renda','Lucro/Prejuizo', 'Despesas'],
                    datasets: [{
                        label: 'Valores',
                        data:[this.total.receita, this.total.lucroPrejuizo, this.total.despesas],
                        backgroundColor: [
                            'rgba(75, 192, 192, 1)',
                            'rgba(255, 99, 132, 1)',
                            'rgba(240, 72, 51,  1)'                            
                        ],
                        borderColor: [
                            'rgba(75, 192, 192, 1)',
                            'rgba(255, 99, 132, 1)',
                            'rgba(255, 206, 86, 1)'   
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });       
        }  
    );}
    mostrarGraficoRadar(){
        this.totalService.listarTotal(this.id).subscribe(dados => { 
            this.total = dados;
            
            var div = document.getElementById('chart-radar');
            var canvas = document.createElement('CANVAS')
            canvas.style.height = '100px'
            canvas.id = 'chart-canvas'

            div.appendChild(canvas)
            var ctx = document.getElementById('chart-canvas')

            var myRadarChart = new Chart(ctx, {
                type: 'pie',
                data:{
                    labels: ["Lucratividade %", "Renda","Despesas","Lucro/Prejuizo"],
                    datasets: [{   
                        data:[this.total.lucratividade, this.total.receita, this.total.despesas, this.total.lucroPrejuizo],
                        backgroundColor: [
                            'rgba(242, 100, 50, 1)',
                            'rgba(330, 100, 235, 1)',
                            'rgba(240, 72, 51,  1)',
                            'rgba(255, 159, 64, 1)'                            
                        ],  
                        borderColor: [
                            'rgba(0, 0, 0, 1)',
                            'rgba(0, 0, 0, 1)',
                            'rgba(0, 0, 0, 1)',
                            'rgba(0, 0, 0, 1)'
                        ],
                    }],
                } 
            });
        }   
    );}
}