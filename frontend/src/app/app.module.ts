import { MoradiaService } from './services/moradia-service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http'
import { CurrencyMaskModule } from "ng2-currency-mask";

import { LayoutAlisson } from './containers/layout-full/layout.full.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EntrarComponent } from './containers/pages/entrar/entrar.component';
import { CategoriaComponent } from './containers/pages/categoria/categoria.component';
import { SituacaoComponent } from './containers/pages/situacao/situacao.component';
import { TotalService } from './services/total-service';
import { AlimentacaoService } from './services/alimentacao-service';
import { TransporteService } from './services/transporte-service';
import { RendaService } from './services/valor-service';
import { EntrarService } from './services/entrar-service';


 
@NgModule({
  declarations: [
    AppComponent,
    LayoutAlisson,
    CategoriaComponent,
    EntrarComponent,
    SituacaoComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    CurrencyMaskModule,
    BrowserAnimationsModule,
    HttpClientModule,
    

  ],
  providers: [TotalService, AlimentacaoService, TransporteService, MoradiaService, RendaService, EntrarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
