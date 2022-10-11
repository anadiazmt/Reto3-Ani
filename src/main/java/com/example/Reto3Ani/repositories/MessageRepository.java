package com.example.Reto3Ani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3Ani.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}