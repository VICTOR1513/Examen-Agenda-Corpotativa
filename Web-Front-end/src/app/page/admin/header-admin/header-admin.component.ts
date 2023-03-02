import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-admin',
  templateUrl: './header-admin.component.html',
  styleUrls: ['./header-admin.component.css']
})
export class HeaderAdminComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  public cerrarSesion(): void {
    this.router.navigate(['Login']);
  }

  public home(): void {
    this.router.navigate(['Home']);
  }
/*
  public catalogoUsuarios(): void {
    this.router.navigate(['Catalogo-Usuarios']);
  }
  public contactos(): void {
    this.router.navigate(['Contactos']);
  }

  public catalogoCategorias(): void {
    this.router.navigate(['Catalogo-Categorias']);
  }*/

  public eventos(): void {
    this.router.navigate(['eventos']);
  }

  public participantes(): void {
    this.router.navigate(['participantes']);
  }





}
