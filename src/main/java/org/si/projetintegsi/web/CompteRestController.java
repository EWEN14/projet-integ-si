package org.si.projetintegsi.web;

import io.swagger.v3.oas.annotations.Operation;
import org.si.projetintegsi.entities.Compte;
import org.si.projetintegsi.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comptes")
public class CompteRestController {

  private CompteRepository compteRepository;

  @Autowired
  public void setCompteRepository(CompteRepository compteRepository) {
    this.compteRepository = compteRepository;
  }

  @Operation(summary = "Récupération de tous les comptes.")
  @GetMapping()
  public List<Compte> listComptes() {
    return compteRepository.findAll();
  }

  @Operation(summary = "Récupération d'un compte.")
  @GetMapping(path = "/{id}")
  public Compte getCompte(@PathVariable(name = "id") Long code) {
    Optional<Compte> compte = compteRepository.findById(code);
    return compte.orElse(null);
  }

  @Operation(summary = "Création d'un compte.")
  @PostMapping()
  public Compte save(@RequestBody Compte compte) {
    return compteRepository.save(compte);
  }

  @Operation(summary = "Modification d'un compte.")
  @PutMapping(path = "/{id}")
  public Compte update(@RequestBody Compte compte) {
    return compteRepository.save(compte);
  }
}
