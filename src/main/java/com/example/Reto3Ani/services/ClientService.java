package com.example.Reto3Ani.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3Ani.entities.Client;
import com.example.Reto3Ani.repositories.ClientRepository;


@Service
public class ClientService {
    
        @Autowired
        private final ClientRepository clientRepository;

        public ClientService(ClientRepository clientRepository) {
            this.clientRepository = clientRepository;
        }

        // METODOS CRUD
        public List<Client> getListClients(){
            return this.clientRepository.findAll();
        }

        public Client getClient(int id){
            if(!this.clientRepository.findById(id).isEmpty()){
                return this.clientRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Client crearClient(Client client){
            return this.clientRepository.save(client);
        }

        public void eliminarClient(int id){
            if(!this.clientRepository.findById(id).isEmpty()){
                this.clientRepository.deleteById(id);
            }
        }

        public void actualizarClient(int id, Client client){
            if(!this.clientRepository.findById(id).isEmpty()){
                Client clientDB = this.clientRepository.findById(id).get();

                this.clientRepository.save(clientDB);
            }
        }
}
