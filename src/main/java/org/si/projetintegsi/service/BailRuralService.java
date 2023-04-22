package org.si.projetintegsi.service;

import org.si.projetintegsi.entities.BailRural;
import org.si.projetintegsi.entities.Coordonnees;
import org.si.projetintegsi.repositories.BailRuralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BailRuralService {

  private BailRuralRepository bailRuralRepository;

  @Autowired
  public void setBailRuralRepository(BailRuralRepository bailRuralRepository) {
    this.bailRuralRepository = bailRuralRepository;
  }

  /**
   * Sauvegarde d'un bail rural à partir du tableau reçu par le script Python
   * @param coordonnees
   */
  public void saveBailRural(Double[][] coordonnees) {
    BailRural bailRural = new BailRural();
    List<Coordonnees> listCoordonnees = new ArrayList<>();

    for (Double[] coordonneeDouble: coordonnees) {
      Coordonnees coordonnee = new Coordonnees();
      coordonnee.setLatitude_x(coordonneeDouble[0]);
      coordonnee.setLongitude_y(coordonneeDouble[1]);
      // Association de la coordonnée au bail rural
      coordonnee.setBailRural(bailRural);
      // Ajout de la coordonnée au bail rural
      listCoordonnees.add(coordonnee);
    }

    bailRural.setCoordonneesList(listCoordonnees);
    bailRural.setPolygoneNbCotes(listCoordonnees.size());

    this.bailRuralRepository.save(bailRural);
  }

  /**
   * Récupération de tous les baux ruraux
   * @return liste des baux ruraux avec leurs coordonnées
   */
  public List<BailRural> getAllBauxRuraux() {
    return this.bailRuralRepository.findAll();
  }

  /**
   * Récupération d'un bail rural
   * @param id identifiant du bail recherché
   * @return un bail rural avec ses coordonnées associées
   */
  public BailRural getBailRural(Long id) {
    Optional<BailRural> bailRural = this.bailRuralRepository.findById(id);
    return bailRural.orElse(null);
  }
}
