package com.ista.retail.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "item_factura")
@Data
public class ItemFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

}
