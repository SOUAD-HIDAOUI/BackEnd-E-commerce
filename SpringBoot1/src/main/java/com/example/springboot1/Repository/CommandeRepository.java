package com.example.springboot1.Repository;

import com.example.springboot1.model.Commande;
import com.example.springboot1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande> findAll();
    void deleteById(Long id);
    Commande getCommentById(Long id);
}
