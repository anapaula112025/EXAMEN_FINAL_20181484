package com.example.demoexamen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "distribuidoras")
@Getter
@Setter
@JsonIgnoreProperties("id")
public class Distribuidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fundacion", nullable = false)
    private Integer fundacion;

    @Column(name = "web")
    private String web;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Sede sede;

}
