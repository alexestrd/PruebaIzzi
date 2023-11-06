import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConsultasModel } from '../Model/consultasModel';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {

  baseUrl= 'http://localhost:8080/api';
  constructor(private http: HttpClient) { }

  registar_Consulta(datos: ConsultasModel) {
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }

    return this.http.post(`${this.baseUrl}/consulta`, datos )
  }

  obtenerConsultas(){
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }
    return this.http.get(`${this.baseUrl}/consultas`, httOptions)
  }
  eliminarConsulta(id: number){
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }
    return this.http.delete(`${this.baseUrl}/consulta/${id}`);
  }
}
