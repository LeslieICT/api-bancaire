package com.banque.model;

public class CompteRequest {
    private String nomTitulaire;
    private double soldeInitial;

    public String getNomTitulaire() { return nomTitulaire; }
    public void setNomTitulaire(String nomTitulaire) { this.nomTitulaire = nomTitulaire; }
    public double getSoldeInitial() { return soldeInitial; }
    public void setSoldeInitial(double soldeInitial) { this.soldeInitial = soldeInitial; }
}