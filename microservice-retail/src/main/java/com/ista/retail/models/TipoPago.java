package com.ista.retail.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipo_pago")
@Data
public class TipoPago {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;
    private String descripcion;

    @OneToMany(mappedBy = "tipo_pago", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Factura> facturas;

}
