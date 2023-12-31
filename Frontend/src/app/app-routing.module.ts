import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Auth/login/login.component';
import { RegisterComponent } from './Auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { loginGuard } from './guards/login.guard';
import { MapaComponent } from './components/mapa/mapa.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registro', component: RegisterComponent},
  {path: 'inicio', component: HomeComponent, canActivate: [loginGuard]},
  {path: 'mapa', component: MapaComponent, canActivate: [loginGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
