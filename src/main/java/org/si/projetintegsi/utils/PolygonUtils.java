package org.si.projetintegsi.utils;

public class PolygonUtils {

  public static Double calculerAirePolygone(Double[][] coordonnees) {
    int n = coordonnees.length;
    double somme = 0.0;
    for (int i = 0; i < n; i++) {
      Double x1 = coordonnees[i][0];
      Double y1 = coordonnees[i][1];
      Double x2 = coordonnees[(i + 1) % n][0];
      Double y2 = coordonnees[(i + 1) % n][1];
      somme += (x2 - x1) * (y1 + y2);
    }
    return Math.abs(somme) / 2.0;
  }

  public static boolean estPolygoneValide(Double[][] coordonnees) {
    // vérifie que le nombre de sommets du polygone est supérieur ou égal à 3
    int n = coordonnees.length;
    if (n < 3) {
      return false;
    }

    // vérifie que l'aire du polygone est non nulle
    Double aire = calculerAirePolygone(coordonnees);
    if (aire <= 0.0) {
      return false;
    }

    // Vérifie que tous les côtés du polygone ont une longueur non nulle
    for (int i = 0; i < n; i++) {
      Double x1 = coordonnees[i][0];
      Double y1 = coordonnees[i][1];
      Double x2 = coordonnees[(i + 1) % n][0];
      Double y2 = coordonnees[(i + 1) % n][1];
      if (x1.equals(x2) && y1.equals(y2)) {
        return false;
      }
    }
    return true;
  }
}
