package com.example.demoexamen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editoras")
@Getter
@Setter
@JsonIgnoreProperties("id")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideditora", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
