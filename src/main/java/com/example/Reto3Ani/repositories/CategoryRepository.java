package com.example.Reto3Ani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3Ani.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}