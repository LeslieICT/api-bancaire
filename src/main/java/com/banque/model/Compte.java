package com.banque.model;

import java.util.UUID;

public class Compte {

    private String id;
    private String nomTitulaire;
    private double solde;

    public Compte() {}

    public Compte(String nomTitulaire, double solde) {
        this.id = UUID.randomUUID().toString();
        this.nomTitulaire = nomTitulaire;
        this.solde = solde;
    }

    public String getId() { return id; }
    public String getNomTitulaire() { return nomTitulaire; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}