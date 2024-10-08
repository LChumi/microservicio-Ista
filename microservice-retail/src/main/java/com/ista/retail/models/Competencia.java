package com.ista.retail.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "competencia")
@Data
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "competencias")
    private List<Rol> roles = new ArrayList<>();
}
