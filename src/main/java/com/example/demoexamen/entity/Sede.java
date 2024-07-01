package com.example.demoexamen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paises")
@Getter
@Setter
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais", nullable = false)
    private Integer id;

    @Column(name = "iso")
    private String iso;

    @Column(name = "nombre")
    private String nombre;
}
