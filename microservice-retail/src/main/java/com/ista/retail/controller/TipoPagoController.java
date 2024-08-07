package com.ista.retail.controller;

import com.ista.retail.models.TipoPago;
import com.ista.retail.service.ITipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipopago")
@CrossOrigin("*")
public class TipoPagoController {

    @Autowired
    private ITipoPagoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoPago>> getTipoPago() {
        try {
            List<TipoPago> clasificacionList= service.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable("id") Long id) {
        try {
            TipoPago clasificacion = service.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<TipoPago> saveTipoPago(@RequestBody TipoPago clasificacion) {
        try {
            TipoPago clasificacionNew = service.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoPago> updateTipoPago(@RequestBody TipoPago tipo, @PathVariable("id") Long id) {
        try {
            TipoPago found  = service.findById(id);
            TipoPago update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setTipo(tipo.getTipo());
            found.setDescripcion(tipo.getDescripcion());
            update= service.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
