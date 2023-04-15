package org.si.projetintegsi.web;

import io.swagger.v3.oas.annotations.Operation;
import org.si.projetintegsi.entities.SmartContrat;
import org.si.projetintegsi.entities.enums.Coordonnees;
import org.si.projetintegsi.repositories.SmartContratRepository;
import org.si.projetintegsi.utils.PolygonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(path = "/smartcontract")
public class SmartContractController {

  private SmartContratRepository smartContratRepository;

  @Autowired
  public void setCompteRepository(SmartContratRepository compteRepository) {
    this.smartContratRepository = compteRepository;
  }

  @Operation(summary = "Récupération des coordonnées")
  @PostMapping()
  public ResponseEntity<String> postCoordonnees(@RequestBody Coordonnees coordonnees) {
    // Faites quelque chose avec le tableauCoordonnees de coordonnées, par exemple :
    Double[][] tableauCoordonnees = coordonnees.getCoordonnees();
    System.out.println(Arrays.deepToString(tableauCoordonnees));
    if (PolygonUtils.estPolygoneValide(tableauCoordonnees)) {
      return ResponseEntity.ok("Coordonnées postées avec succès !");
    } else {
      return ResponseEntity.badRequest().body("Les coordonnées ne représente pas un polygone");
    }
  }

  @Operation(summary = "Enregistrement d'un smart contract.")
  @PostMapping("/smart")
  public SmartContrat save(@RequestBody SmartContrat smartContrat) {
    return smartContratRepository.save(smartContrat);
  }
}
