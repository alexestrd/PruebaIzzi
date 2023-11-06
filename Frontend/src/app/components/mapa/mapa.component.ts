import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { CordenadasModel } from 'src/app/Model/cordeModel';
import { CordService } from 'src/app/Services/cord.service';


declare var google: any;

@Component({
  selector: 'app-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.css']
})
export class MapaComponent implements OnInit {
  mapa: any; // Variable para el mapa
  cor: CordenadasModel={
    lat: 19.3031,
    lon: -99.6321
  }
  constructor(private corService: CordService){}

  ngOnInit(): void {
    this.initMap();
  }
  initMap(){
    this.cor = this.corService.obternerCor();
    console.log(this.cor.lat);
    console.log(this.cor.lon);

    const mapOptions = {
      center: new google.maps.LatLng(this.cor.lat,this.cor.lon), // Latitud y longitud de Nueva York
      zoom: 15, // Nivel de zoom
      mapTypeId: google.maps.MapTypeId.ROADMAP // Tipo de mapa
    };

    // Crea el mapa en el elemento con el ID "map" en el template
    this.mapa = new google.maps.Map(document.getElementById('map'), mapOptions);
  }
  
}
