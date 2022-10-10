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

import com.example.Reto3Ani.entities.Category;
import com.example.Reto3Ani.services.CategoryService;

@RestController
@RequestMapping("api/Category")
public class CategoryController {    

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> getCategorys(){
        return new ResponseEntity<>(this.categoryService.getListCategorys(), HttpStatus.OK);
    }

    //@GetMapping("/all")
   // public List<Category> getAll() { return categoryService.getAll();}

    

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") int id){
        return new ResponseEntity<>(this.categoryService.getCategory(id), HttpStatus.OK);
    }

    @PostMapping("/save")

    public ResponseEntity<?> crearCategory(@RequestBody Category category){
        return new ResponseEntity<>(this.categoryService.crearCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategory(@PathVariable("id") int id){
        this.categoryService.eliminarCategory(id);
        return new ResponseEntity<>("Category Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarCategory(@RequestBody Category category){
        this.categoryService.actualizarCategory(category.getId(), category);
        return new ResponseEntity<>("Category Actualizado", HttpStatus.CREATED);
    }
    

}
