package com.ista.retail.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String rol;
    private Boolean estado;

    @ManyToMany(mappedBy = "rol")
    private List<Usuario> usuarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "rol_competencia", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private List<Competencia> competencias = new ArrayList<>();
}
