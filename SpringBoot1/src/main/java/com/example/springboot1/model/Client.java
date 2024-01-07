package com.example.springboot1.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "clients")

public class Client implements Serializable {
//    private boolean locked;
//    private boolean enabled;
//    @Enumerated(EnumType.STRING)
//    private UserRole userRole;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Comment> commandes;


    public Client() {
    }

    public Client( String nom, String prenom, String email,String password) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password=password;
    }

    public Client(String name, String s) {
        this.prenom=name;
        this.nom=s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
        comment.setClient(this);
    }



}
