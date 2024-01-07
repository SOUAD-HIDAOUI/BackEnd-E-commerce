package com.example.springboot1.Service;

import com.example.springboot1.Repository.ClientRepository;
import com.example.springboot1.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService   {
    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);

    }
    public Client fetchClientByEmail(String email){
        return clientRepository.findClientByEmail(email);
    }
    public Client fetchClientByEmailAndPassword(String email,String password){
        return clientRepository.findClientByEmailAndAndPassword(email,password);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public void remove(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client getClientById(Long id) {
        return clientRepository.getClientById(id);
    }



    public void update(Client existingClient) {
        clientRepository.saveAndFlush(existingClient);
    }


}
