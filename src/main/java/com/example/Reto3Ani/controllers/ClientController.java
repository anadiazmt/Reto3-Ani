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

import com.example.Reto3Ani.entities.Client;
import com.example.Reto3Ani.services.ClientService;

@RestController
@RequestMapping("api/Client")
public class ClientController {    

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<?> getClients(){
        return new ResponseEntity<>(this.clientService.getListClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") int id){
        return new ResponseEntity<>(this.clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> crearClient(@RequestBody Client client){
        return new ResponseEntity<>(this.clientService.crearClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarClient(@PathVariable("id") int id){
        this.clientService.eliminarClient(id);
        return new ResponseEntity<>("Client Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarClient(@RequestBody Client client){
        this.clientService.actualizarClient(client.getId(), client);
        return new ResponseEntity<>("Client Actualizado", HttpStatus.CREATED);
    }
    

}

