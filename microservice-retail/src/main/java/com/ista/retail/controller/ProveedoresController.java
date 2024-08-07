package com.ista.retail.controller;

import com.ista.retail.models.Proveedores;
import com.ista.retail.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
@CrossOrigin("*")
public class ProveedoresController {

    @Autowired
    private IProveedoresService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Proveedores>> getProveedores() {
        try {
            List<Proveedores> clasificacionList= service.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Proveedores> getProveedoresById(@PathVariable("id") Long id) {
        try {
            Proveedores clasificacion = service.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Proveedores> saveProveedores(@RequestBody Proveedores clasificacion) {
        try {
            Proveedores clasificacionNew = service.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Proveedores> updateProveedores(@RequestBody Proveedores p, @PathVariable("id") Long id) {
        try {
            Proveedores found  = service.findById(id);
            Proveedores update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setCorreo(p.getCorreo());
            found.setPais(p.getPais());
            found.setMoneda(p.getMoneda());
            found.setRuc(p.getRuc());
            found.setTelefono(p.getTelefono());
            update= service.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProveedores(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
