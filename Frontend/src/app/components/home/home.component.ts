import { Component } from '@angular/core';
import { ConsultasModel } from 'src/app/Model/consultasModel';
import { ConsultasService } from 'src/app/Services/consultas.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  datos :any = [];

  constructor(private consultaService: ConsultasService){}

  ngOnInit():void{
    this.consultaService.obtenerConsultas().subscribe(res =>{
      console.log(res);
      this.datos = res;
    },err => console.error(err));
  }

  
}
