package com.example.springboot1.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import java.io.Serializable;
@Entity
@Table(name = "commandes")

public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "commande")
    private Set<DetailCommande> detailCommandes;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Commande() {}


}
