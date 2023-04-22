package org.si.projetintegsi.web;

import io.swagger.v3.oas.annotations.Operation;
import org.si.projetintegsi.entities.BailRural;
import org.si.projetintegsi.entities.CoordonneesDouble;
import org.si.projetintegsi.service.BailRuralService;
import org.si.projetintegsi.utils.PolygonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/bailrural")
public class BailRuralController {

  private BailRuralService bailRuralService;

  @Autowired
  public void setCompteRepository(BailRuralService bailRuralService) {
    this.bailRuralService = bailRuralService;
  }

  @Operation(summary = "Récupération des coordonnées")
  @PostMapping()
  public ResponseEntity<String> postCoordonnees(@RequestBody CoordonneesDouble coordonnees) {
    // Faites quelque chose avec le tableauCoordonnees de coordonnées, par exemple :
    Double[][] tableauCoordonnees = coordonnees.getCoordonnees();

    // Affichage des coordonnées reçues dans la console
    System.out.println(Arrays.deepToString(tableauCoordonnees));

    // Vérification si les coordonnées représente bien un polygone
    if (PolygonUtils.estPolygoneValide(tableauCoordonnees)) {
      // Si oui, on sauvegarde le bail rural dans la base H2 et on retourne un message de succès
      this.bailRuralService.saveBailRural(tableauCoordonnees);
      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + "; charset=UTF-8")
              .body("Coordonnees postees avec succes !");
    } else {
      // Sinon on retourne un message d'échec
      return ResponseEntity.badRequest()
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + "; charset=UTF-8")
              .body("Les coordonnees ne representent pas un polygone valide.");
    }
  }

  @Operation(summary = "Récupérations de tous les baux ruraux")
  @GetMapping()
  public ResponseEntity<List<BailRural>> getAllBauxRuraux() {
    return ResponseEntity.ok().body(this.bailRuralService.getAllBauxRuraux());
  }

  @Operation(summary = "Récupération d'un bail rural")
  @GetMapping("/{id}")
  public ResponseEntity<BailRural> getBailRural(@RequestParam Long id) {
    BailRural bailRural = this.bailRuralService.getBailRural(id);
    if (bailRural != null) {
      return ResponseEntity.ok(bailRural);
    }
    // Erreur 404 retournée si bail rural inexistant avec l'id fournie
    return ResponseEntity.notFound().build();
  }
}
