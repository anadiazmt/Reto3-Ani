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

import com.example.Reto3Ani.entities.Reservation;
import com.example.Reto3Ani.services.ReservationService;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {    

    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<?> getReservations(){
        return new ResponseEntity<>(this.reservationService.getListReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservation(@PathVariable("id") int id){
        return new ResponseEntity<>(this.reservationService.getReservation(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> crearReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(this.reservationService.crearReservation(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReservation(@PathVariable("id") int id){
        this.reservationService.eliminarReservation(id);
        return new ResponseEntity<>("Reservation Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarReservation(@RequestBody Reservation reservation){
        this.reservationService.actualizarReservation(reservation.getId(), reservation);
        return new ResponseEntity<>("Reservation Actualizado", HttpStatus.CREATED);
    }
    

}

