package com.ista.retail.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long stock;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    private String unidad;
    private BigDecimal iva;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", referencedColumnName = "id")
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedores proveedores;

}
