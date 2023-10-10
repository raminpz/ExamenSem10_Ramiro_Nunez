package com.softrami.examensem10.infraestructure.entity;

import com.softrami.examensem10.domain.model.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String usuario;
    private String password;
    private int estado;
    @Column(name = "fecha_crea")
    private LocalDate fechaRegistro;
    @Column(name = "fecha_mod")
    private LocalDate fechaModif;
    @OneToOne
    @JoinColumn(name = "personEntity_id")
    private PersonEntity person;

    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro = LocalDate.now();
    }

    public UserEntity(Long id, String usuario, String password, int estado, LocalDate fechaRegistro, LocalDate fechaModif) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.fechaModif = fechaModif;
        this.person = person;
    }

    public UserEntity() {

    }

    public static UserEntity fromDomainModel(User user){
        return new UserEntity(user.getId(), user.getUsuario(), user.getPassword(), user.getEstado(), user.getFechaRegistro(),user.getFechaModif());
    }

    public User toDomainModel(){
        return new User(id,usuario,password,estado,fechaRegistro,fechaModif);
    }
}
