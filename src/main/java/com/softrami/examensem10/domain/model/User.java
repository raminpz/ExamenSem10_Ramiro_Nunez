package com.softrami.examensem10.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long id;
    private String usuario;
    private String password;
    private int estado;
    @Column(name = "fecha_crea")
    private LocalDate fechaRegistro;
    @Column(name = "fecha_mod")
    private LocalDate fechaModif;
    /*
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person persons;
     */

    public User(Long id, String usuario, String password, int estado, LocalDate fechaRegistro, LocalDate fechaModif) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.fechaModif = fechaModif;
    }
}
