package org.si.projetintegsi.dto;

import lombok.Data;

@Data
public class VirementRequestDTO {

  private Long compteSource;

  private Long compteDestination;

  private Double montant;
}
