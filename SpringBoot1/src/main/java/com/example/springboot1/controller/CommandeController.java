package com.example.springboot1.controller;

import com.example.springboot1.Service.ClientService;
import com.example.springboot1.Service.CommandeService;
import com.example.springboot1.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/commandes")

public class CommandeController {
    @Autowired
    private CommandeService commandeService;
    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        Commande addedCommande = commandeService.addCommande(commande);
        return new ResponseEntity<>(addedCommande, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> allCommandes = commandeService.findAllCommande();
        return new ResponseEntity<>(allCommandes, HttpStatus.OK);
    }
}
