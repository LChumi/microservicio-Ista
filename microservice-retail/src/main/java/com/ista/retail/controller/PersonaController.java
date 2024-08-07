package com.ista.retail.controller;

import com.ista.retail.models.Persona;
import com.ista.retail.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persona")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> getPersona() {
        try {
            List<Persona> clasificacionList= service.findByAll();
            return ResponseEntity.ok(clasificacionList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") Long id) {
        try {
            Persona clasificacion = service.findById(id);
            if (clasificacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clasificacion);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona clasificacion) {
        try {
            Persona clasificacionNew = service.save(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(clasificacionNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona, @PathVariable("id") Long id) {
        try {
            Persona found  = service.findById(id);
            Persona update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setApellido(persona.getApellido());
            found.setNombre(persona.getNombre());
            found.setDni(persona.getDni());
            found.setCelular(persona.getCelular());
            found.setCorreo(persona.getCorreo());
            update= service.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
