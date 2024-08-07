package com.ista.retail.controller;

import com.ista.retail.models.Clasificacion;
import com.ista.retail.service.IClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clasificacion")
@CrossOrigin("*")
public class ClasificacionController {

    @Autowired
    private IClasificacionService clasificacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Clasificacion>> getClasificacion() {
        try {
            List<Clasificacion> clasificacionList= clasificacionService.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Clasificacion> getClasificacionById(@PathVariable("id") Long id) {
        try {
            Clasificacion clasificacion = clasificacionService.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Clasificacion> saveClasificacion(@RequestBody Clasificacion clasificacion) {
        try {
            Clasificacion clasificacionNew = clasificacionService.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Clasificacion> updateClasificacion(@RequestBody Clasificacion clasificacion, @PathVariable("id") Long id) {
        try {
            Clasificacion found  = clasificacionService.findById(id);
            Clasificacion update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setGrupo(clasificacion.getGrupo());
            update= clasificacionService.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteClasificacion(@PathVariable("id") Long id) {
        clasificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
