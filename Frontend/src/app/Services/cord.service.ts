import { Injectable } from '@angular/core';
import { CordenadasModel } from '../Model/cordeModel';

@Injectable({
  providedIn: 'root'
})
export class CordService {
  cor: CordenadasModel ={
    lat: 19.3031,
    lon: -99.6321
  }
  constructor() { }

  llenarCor(long:number, lat:number){
    this.cor.lat = lat;
    this.cor.lon = long;
  }

  obternerCor(){
    return this.cor;
  }
}
