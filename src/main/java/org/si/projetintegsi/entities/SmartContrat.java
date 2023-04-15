package org.si.projetintegsi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SmartContrat {

  @Id
  Long owner;

  String contratName;

  String gps;
}
