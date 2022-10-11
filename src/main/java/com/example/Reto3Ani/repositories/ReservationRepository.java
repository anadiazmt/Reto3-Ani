package com.example.Reto3Ani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3Ani.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer>{
}