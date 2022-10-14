package com.example.Reto3Ani.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3Ani.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer>{
    public List<Reservation> findByStartDateBetween(Date start, Date end);
    public List<Reservation> findByStatus(String status);
}