package com.banque.controller;

import com.banque.model.Compte;
import com.banque.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController          // Dit que cette classe gère des requêtes HTTP
@RequestMapping("/comptes") // Toutes les routes commencent par /comptes
public class CompteController {

    @Autowired // Spring injecte automatiquement le service
    private CompteService compteService;

    // Route GET /comptes → retourne la liste de tous les comptes
    @GetMapping
    public List<Compte> obtenirTousLesComptes() {
        return compteService.obtenirTousLesComptes();
    }

    // Route POST /comptes → crée un nouveau compte
    @PostMapping
    public Compte creerCompte(@RequestBody Map<String, Object> body) {
        String nom = (String) body.get("nomTitulaire");
        double solde = ((Number) body.get("soldeInitial")).doubleValue();
        return compteService.creerCompte(nom, solde);
    }
}