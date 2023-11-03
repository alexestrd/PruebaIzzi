package com.example.izzi.Izzi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consultas")
public class consultasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "ip")
    private String ip;

    @Getter @Setter @Column(name = "cp")
    private int cp;

    @Getter @Setter @Column(name = "ciudad")
    private String ciudad;

    @Getter @Setter @Column(name = "pais")
    private String pais;

    @Getter @Setter @Column(name = "estado")
    private String estado;

    @Getter @Setter @Column(name = "idioma")
    private String idioma;

    @Getter @Setter @Column(name = "moneda")
    private String moneda;

    @Getter @Setter @Column(name = "continente")
    private String continente;

    @Getter @Setter @Column(name = "longitud")
    private String longitud;

    @Getter @Setter @Column(name = "latitud")
    private String latitud;
}
