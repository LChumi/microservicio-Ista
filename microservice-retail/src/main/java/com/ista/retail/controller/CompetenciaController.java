package com.ista.retail.controller;

import com.ista.retail.models.Competencia;
import com.ista.retail.service.ICompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/competencia")
@CrossOrigin("*")
public class CompetenciaController {

    @Autowired
    private ICompetenciaService competenciaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Competencia>> getCompetencia() {
        try {
            List<Competencia> CompetenciaList= competenciaService.findByAll();
            return ResponseEntity.ok(CompetenciaList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Competencia> getCompetenciaById(@PathVariable("id") Long id) {
        try {
            Competencia Competencia = competenciaService.findById(id);
            if (Competencia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(Competencia);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Competencia> saveCompetencia(@RequestBody Competencia Competencia) {
        try {
            Competencia CompetenciaNew = competenciaService.save(Competencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(CompetenciaNew);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Competencia> updateCompetencia(@RequestBody Competencia competencia, @PathVariable("id") Long id) {
        try {
            Competencia found  = competenciaService.findById(id);
            Competencia update;
            if (found == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            found.setNombre(competencia.getNombre());
            found.setDescripcion(competencia.getDescripcion());
            update= competenciaService.save(found);
            return ResponseEntity.ok(update);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCompetencia(@PathVariable("id") Long id) {
        competenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
