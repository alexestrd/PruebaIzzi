import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ConsultasModel } from 'src/app/Model/consultasModel';
import { ConsultasService } from 'src/app/Services/consultas.service';
import { CordService } from 'src/app/Services/cord.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  datos :any = [];
  busca : ConsultasModel ={
    id: 0,
    nombre: "",
    ip: "",
    cp: 0,
    ciudad: "",
    pais: "",
    estado: "",
    idioma: "",
    moneda: "",
    continente: "",
    longitud: "",
    latitud: "",
  }

  constructor(private consultaService: ConsultasService, private cordService: CordService, private router:Router){}

  ngOnInit():void{
    this.consultaService.obtenerConsultas().subscribe(res =>{
      console.log(res);
      this.datos = res;
    },err => console.error(err));
  }

  eliminar(id: number){
    this.consultaService.eliminarConsulta(id).subscribe(
      res => {
        console.log(res);
      }, err => console.error(err)
    )
  }
  buscar(){
    this.busca.nombre = localStorage.getItem("username") ?? "indefinido";
    console.log(this.busca);
    this.consultaService.registar_Consulta(this.busca).subscribe(
      res => {
        console.log(res);
      }, err => console.error(err)
    )
  }
  mapa(lat:number,long:number){
    this.cordService.llenarCor(lat,long);
    this.router.navigate(['/mapa']);
  }
}
