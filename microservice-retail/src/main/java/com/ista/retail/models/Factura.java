package com.ista.retail.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
public class Factura {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ruc;
    private LocalDate fecha;
    private BigDecimal descuento;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago",referencedColumnName = "id")
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private Persona persona;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ItemFactura> items;


}
