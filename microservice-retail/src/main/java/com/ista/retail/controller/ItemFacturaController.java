package com.ista.retail.controller;

import com.ista.retail.models.ItemFactura;
import com.ista.retail.service.IItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@CrossOrigin("*")
public class ItemFacturaController {

    @Autowired
    private IItemFacturaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ItemFactura>> getItemFactura() {
        try {
            List<ItemFactura> clasificacionList= service.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ItemFactura> getItemFacturaById(@PathVariable("id") Long id) {
        try {
            ItemFactura clasificacion = service.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<ItemFactura> saveItemFactura(@RequestBody ItemFactura clasificacion) {
        try {
            ItemFactura clasificacionNew = service.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ItemFactura> updateItemFactura(@RequestBody ItemFactura clasificacion, @PathVariable("id") Long id) {
        try {
            ItemFactura found  = service.findById(id);
            ItemFactura update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setCantidad(clasificacion.getCantidad());
            found.setPrecio(clasificacion.getPrecio());
            found.setProducto(clasificacion.getProducto());
            update= service.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteItemFactura(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
