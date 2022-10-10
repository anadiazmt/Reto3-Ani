package com.example.Reto3Ani.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "message")
public class Message implements Serializable{

    //***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "messageText")
    private String messageText;

    //***** RELACIONES *****
    //Relacion Muchos a uno. El Message tiene enlazados un Client y Una Ortesis
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client client;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ortesis_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Ortesis ortesis;

    //***** METODOS *****
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ortesis getOrtesis() {
        return ortesis;
    }

    public void setOrtesis(Ortesis ortesis) {
        this.ortesis = ortesis;
    }

    
}
