package com.example.springboot1.model;


import javax.persistence.*;
import java.util.Set;

import java.io.Serializable;

@Entity
@Table(name = "produits ")

public class Produit implements Serializable {
    @Id
    @Column(name = "ID")

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
