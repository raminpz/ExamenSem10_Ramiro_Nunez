package com.softrami.examensem10.infraestructure.entity;

import com.softrami.examensem10.domain.model.Person;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro = LocalDate.now();
    }
    public PersonEntity(Long id, String nombre, String apellidos, String direccion, String email, String telefono, int estado, LocalDate fechaRegistro, LocalDate fechaModif) {
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

    public PersonEntity() {

    }

    public static PersonEntity fromDomainModel(Person person){
        return new PersonEntity(person.getId(), person.getNombre(), person.getApellidos(), person.getDireccion(), person.getEmail(), person.getTelefono(), person.getEstado(),person.getFechaRegistro(),person.getFechaModif());
    }

    public Person toDomainModel(){
        return new Person(id,nombre,apellidos,direccion,email,telefono,estado,fechaRegistro,fechaModif);
    }
}
