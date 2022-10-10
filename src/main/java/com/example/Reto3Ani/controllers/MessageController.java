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

import com.example.Reto3Ani.entities.Message;
import com.example.Reto3Ani.services.MessageService;

@RestController
@RequestMapping("api/Message")
public class MessageController {    

    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<?> getMessages(){
        return new ResponseEntity<>(this.messageService.getListMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessage(@PathVariable("id") int id){
        return new ResponseEntity<>(this.messageService.getMessage(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> crearMessage(@RequestBody Message message){
        return new ResponseEntity<>(this.messageService.crearMessage(message), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMessage(@PathVariable("id") int id){
        this.messageService.eliminarMessage(id);
        return new ResponseEntity<>("Message Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarMessage(@RequestBody Message message){
        this.messageService.actualizarMessage(message.getId(), message);
        return new ResponseEntity<>("Message Actualizado", HttpStatus.CREATED);
    }
    

}