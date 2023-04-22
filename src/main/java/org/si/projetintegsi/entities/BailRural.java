package org.si.projetintegsi.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Bail Rural, constitué d'une liste de coordonnées
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bail_rural")
public class BailRural {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idBailRural;

  // Nombre de côté dont est constitué le polygone du bail rural
  private Integer polygoneNbCotes;

  // Liste des coordonnées représentant la délimitation du bail rural
  @OneToMany(mappedBy = "bailRural", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<Coordonnees> coordonneesList = new ArrayList<>();

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  private LocalDateTime CreatedAt;
}
