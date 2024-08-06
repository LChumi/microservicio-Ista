package com.ista.retail.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String ruc;
    private String telefono;
    private String pais;
    private String correo;
    private String moneda;

    @OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;

}
