package com.banque.service;

import com.banque.model.Compte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private List<Compte> comptes = new ArrayList<>();

    // Créer un compte
    public Compte creerCompte(String nomTitulaire, double soldeInitial) {
        Compte nouveau = new Compte(nomTitulaire, soldeInitial);
        comptes.add(nouveau);
        return nouveau;
    }

    // Lister tous les comptes
    public List<Compte> obtenirTousLesComptes() {
        return comptes;
    }

    // Consulter un compte par ID
    public Optional<Compte> obtenirCompteParId(String id) {
        return comptes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    // Effectuer un dépôt
    public Compte deposer(String id, double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être supérieur à 0");
        }
        Compte compte = obtenirCompteParId(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
        compte.setSolde(compte.getSolde() + montant);
        return compte;
    }

    // Effectuer un retrait
    public Compte retirer(String id, double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être supérieur à 0");
        }
        Compte compte = obtenirCompteParId(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
        if (compte.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant");
        }
        compte.setSolde(compte.getSolde() - montant);
        return compte;
    }
}