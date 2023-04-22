package org.si.projetintegsi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Représente le tableau de tableaux de Double
 * que l'on reçoit de la request du script Python
 */
@Getter
@Setter
@NoArgsConstructor
public class CoordonneesDouble {
  private Double[][] coordonnees;
}
