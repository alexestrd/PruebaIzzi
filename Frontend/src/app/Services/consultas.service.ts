import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {

  baseUrl= 'http://localhost:8080/api';
  constructor(private http: HttpClient) { }

  registar_Consulta(datos: FormData) {
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }

    return this.http.post(`${this.baseUrl}/libros`, datos )
  }

  obtenerConsultas(){
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }
    return this.http.get(`${this.baseUrl}/consultas`, httOptions)
  }
}
