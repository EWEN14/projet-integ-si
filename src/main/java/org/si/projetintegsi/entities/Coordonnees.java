package org.si.projetintegsi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Représente une des coordonnées d'un Bail Rural
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coordonnees")
public class Coordonnees {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_coordonnes;

  private Double latitude_x;

  private Double longitude_y;

  // Bail Rural rattaché à cette coordonnée
  @ManyToOne(targetEntity = BailRural.class)
  @JoinColumn(name = "id_bail_rural")
  @JsonIgnore
  private BailRural bailRural;
}
