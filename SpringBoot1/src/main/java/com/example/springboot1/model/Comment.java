package com.example.springboot1.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public Comment(Long id, Client client, String body) {
        this.id = id;
        this.client = client;
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Column
    private String body;

    public void setClient(Client client) {
        this.client=client;
    }
}
