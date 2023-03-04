package org.si.projetintegsi.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.si.projetintegsi.entities.enums.TypeCompte;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long code;

  private Double solde;

  private LocalDate dateCreation;

  @Enumerated(EnumType.STRING)
  private TypeCompte type;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Compte compte = (Compte) o;
    return getCode() != null && Objects.equals(getCode(), compte.getCode());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
