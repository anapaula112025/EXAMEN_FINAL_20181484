package com.example.demoexamen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "juegos")
@Getter
@Setter
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "image")
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataforma plataforma;

    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Distribuidora distribuidora;




}
