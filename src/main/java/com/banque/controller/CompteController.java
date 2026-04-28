package com.banque.controller;

import com.banque.model.Compte;
import com.banque.model.CompteRequest;
import com.banque.model.MontantRequest;
import com.banque.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    // GET /comptes → lister tous les comptes
    @GetMapping
    public List<Compte> obtenirTousLesComptes() {
        return compteService.obtenirTousLesComptes();
    }

    // POST /comptes → créer un compte
    @PostMapping
    public Compte creerCompte(@RequestBody CompteRequest request) {
        return compteService.creerCompte(request.getNomTitulaire(), request.getSoldeInitial());
    }

    // GET /comptes/{id} → consulter un compte
    @GetMapping("/{id}")
    public ResponseEntity<Compte> obtenirCompteParId(@PathVariable String id) {
        return compteService.obtenirCompteParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /comptes/{id}/depot → effectuer un dépôt
@PostMapping("/{id}/depot")
public ResponseEntity<?> deposer(@PathVariable String id, @RequestBody MontantRequest request) {
    try {
        Compte compte = compteService.deposer(id, request.getMontant());
        return ResponseEntity.ok(compte);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

// POST /comptes/{id}/retrait → effectuer un retrait
@PostMapping("/{id}/retrait")
public ResponseEntity<?> retirer(@PathVariable String id, @RequestBody MontantRequest request) {
    try {
        Compte compte = compteService.retirer(id, request.getMontant());
        return ResponseEntity.ok(compte);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

}