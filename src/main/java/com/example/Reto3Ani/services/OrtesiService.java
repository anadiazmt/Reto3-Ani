package com.example.Reto3Ani.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3Ani.entities.Ortesis;
import com.example.Reto3Ani.repositories.OrtesisRepository;


@Service
public class OrtesiService {
    
        @Autowired
        private final OrtesisRepository ortesisRepository;

        public OrtesiService(OrtesisRepository ortesisRepository) {
            this.ortesisRepository = ortesisRepository;
        }

        // METODOS CRUD
        public List<Ortesis> getListOrtesis(){
            return this.ortesisRepository.findAll();
        }

        public Ortesis getOrtesis(int id){
            if(!this.ortesisRepository.findById(id).isEmpty()){
                return this.ortesisRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Ortesis crearOrtesis(Ortesis ortesis){
            return this.ortesisRepository.save(ortesis);
        }

        public void eliminarOrtesis(int id){
            if(!this.ortesisRepository.findById(id).isEmpty()){
                this.ortesisRepository.deleteById(id);
            }
        }

        public void actualizarOrtesis(int id, Ortesis ortesis){
            if(!this.ortesisRepository.findById(id).isEmpty()){
                Ortesis ortesisDB = this.ortesisRepository.findById(id).get();

                this.ortesisRepository.save(ortesisDB);
            }
        }
}
