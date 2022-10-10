package com.example.Reto3Ani.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto3Ani.entities.Ortesis;
import com.example.Reto3Ani.services.OrtesiService;

@RestController
@RequestMapping("api/Ortopedic")
public class OrtesisController {    

    @Autowired
    OrtesiService ortesiService;

    @GetMapping("/all")
    public ResponseEntity<?> getOrtesis(){
        return new ResponseEntity<>(this.ortesiService.getListOrtesis(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrtesis(@PathVariable("id") int id){
        return new ResponseEntity<>(this.ortesiService.getOrtesis(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> crearOrtesis(@RequestBody Ortesis ortesis){
        return new ResponseEntity<>(this.ortesiService.crearOrtesis(ortesis), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOrtesis(@PathVariable("id") int id){
        this.ortesiService.eliminarOrtesis(id);
        return new ResponseEntity<>("Ortesis Eliminada", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarOrtesis(@RequestBody Ortesis ortesis){
        this.ortesiService.actualizarOrtesis(ortesis.getId(), ortesis);
        return new ResponseEntity<>("Ortesis Actualizada", HttpStatus.CREATED);
    }
    
}
