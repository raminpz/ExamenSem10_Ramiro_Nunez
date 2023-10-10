package com.softrami.examensem10.domain.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class Person {

    private Long id;
    @NotNull
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private int estado;
    @Column(name = "fecha_crea")
    private LocalDate fechaRegistro;
    @Column(name = "fecha_mod")
    private LocalDate fechaModif;

    public Person(Long id, String nombre, String apellidos, String direccion, String email, String telefono, int estado, LocalDate fechaRegistro, LocalDate fechaModif) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.fechaModif = fechaModif;
    }
}
