import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormsModule, FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/Services/Auth/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userLogin: any = {
    correo: "",
    contraseña: ""
}
response: any = {
  token: "",
  username: ""
}
  userdata: any = {
  }
  login!: FormGroup;
  constructor(private loginService : LoginService, private router : Router,private fb : FormBuilder){
    this.login = this.fb.group ({
      email: ['',[Validators.required, Validators.email]],
      password: ['', Validators.required]
    }) 
  }


  onSubmit() {
    this.userLogin = {
      correo: this.login.value['email'],
      contraseña: this.login.value['password']
    }
    this.loginService.login(this.userLogin).subscribe(
      (res: any) => {
        this.response = res;
        console.log(res);
        if (this.response && this.response.token) {
          const token = this.response.token;
          const name = this.response.username;
          localStorage.setItem("token", token);
          localStorage.setItem("username", name);
          console.log(localStorage.getItem("token"));
          this.router.navigate(['/inicio']);
        } else {
          console.error("No se recibió un token en la respuesta.");
        }
      },
      (err) => console.error(err)
    )
  }}
