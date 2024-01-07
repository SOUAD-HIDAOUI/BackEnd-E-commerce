package com.example.springboot1.Service;

import com.example.springboot1.Repository.ClientRepository;
import com.example.springboot1.Repository.CommandeRepository;
import com.example.springboot1.model.Client;
import com.example.springboot1.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> findAllCommande() {
        return commandeRepository.findAll();
    }
}
