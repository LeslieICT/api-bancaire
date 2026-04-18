package com.banque.model;

// On importe les outils nécessaires
import java.util.UUID;

public class Compte {

    // Les données d'un compte
    private String id;          // Identifiant unique
    private String nomTitulaire; // Nom du propriétaire
    private double solde;        // Argent disponible

    // Constructeur : appelé quand on crée un compte
    public Compte(String nomTitulaire, double soldeInitial) {
        this.id = UUID.randomUUID().toString(); // Génère un ID unique automatiquement
        this.nomTitulaire = nomTitulaire;
        this.solde = soldeInitial;
    }

    // Getters : permettent de lire les données
    public String getId() { return id; }
    public String getNomTitulaire() { return nomTitulaire; }
    public double getSolde() { return solde; }
}