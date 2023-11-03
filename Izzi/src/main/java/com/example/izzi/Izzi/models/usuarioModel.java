package com.example.izzi.Izzi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class usuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellidos")
    private String apellidos;

    @Getter @Setter @Column(name = "correo")
    private String correo;

    @Getter @Setter @Column(name = "contraseña")
    private String contraseña;

    @Getter @Setter @Column(name = "telefono")
    private Long telefono;


}
