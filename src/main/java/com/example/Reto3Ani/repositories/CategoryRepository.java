package com.example.Reto3Ani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Reto3Ani.entities.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}