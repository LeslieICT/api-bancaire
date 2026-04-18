package com.banque.service;

import com.banque.model.Compte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Dit à Spring que cette classe est un service
public class CompteService {

    // Notre "base de données" temporaire en mémoire
    private List<Compte> comptes = new ArrayList<>();

    // Créer un nouveau compte
    public Compte creerCompte(String nomTitulaire, double soldeInitial) {
        Compte nouveau = new Compte(nomTitulaire, soldeInitial);
        comptes.add(nouveau); // On l'ajoute à la liste
        return nouveau;       // On retourne le compte créé
    }

    // Obtenir tous les comptes
    public List<Compte> obtenirTousLesComptes() {
        return comptes; // On retourne toute la liste
    }
}