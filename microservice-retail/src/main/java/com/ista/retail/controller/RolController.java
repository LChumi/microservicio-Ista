package com.ista.retail.controller;

import com.ista.retail.models.Rol;
import com.ista.retail.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/factura")
@CrossOrigin("*")
public class RolController {

    @Autowired
    private IRolService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> getRol() {
        try {
            List<Rol> clasificacionList= service.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable("id") Long id) {
        try {
            Rol clasificacion = service.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol clasificacion) {
        try {
            Rol clasificacionNew = service.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol, @PathVariable("id") Long id) {
        try {
            Rol found  = service.findById(id);
            Rol update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setRol(rol.getRol());
            update= service.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
