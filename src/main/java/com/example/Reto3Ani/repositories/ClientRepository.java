package com.example.Reto3Ani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3Ani.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
}