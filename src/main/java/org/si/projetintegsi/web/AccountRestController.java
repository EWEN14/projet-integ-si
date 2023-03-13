package org.si.projetintegsi.web;

import io.swagger.v3.oas.annotations.Operation;
import org.si.projetintegsi.dto.VirementRequestDTO;
import org.si.projetintegsi.service.CompteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

  private final CompteService compteService;

  public AccountRestController(CompteService compteService) {
    this.compteService = compteService;
  }

  @Operation(summary = "Opération de virement d'un compte vers un autre")
  @PutMapping(path = "comptes/virement")
  public void virement(@RequestBody VirementRequestDTO requestDTO) {
    compteService.virement(requestDTO);
  }
}
