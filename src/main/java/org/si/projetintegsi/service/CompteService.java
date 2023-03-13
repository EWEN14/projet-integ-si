package org.si.projetintegsi.service;

import org.si.projetintegsi.dto.VirementRequestDTO;
import org.si.projetintegsi.entities.Compte;
import org.si.projetintegsi.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CompteService {

  private CompteRepository compteRepository;

  @Autowired
  public void setCompteRepository(CompteRepository compteRepository) {
    this.compteRepository = compteRepository;
  }

  public void virement(VirementRequestDTO requestDTO) {
    Optional<Compte> compteDestinationOpt = compteRepository.findById(requestDTO.getCompteDestination());
    Optional<Compte> compteSourceOpt = compteRepository.findById(requestDTO.getCompteSource());

    if (compteDestinationOpt.isPresent() && compteSourceOpt.isPresent()) {
      Compte compteDestination = compteDestinationOpt.get();
      Compte compteSource = compteSourceOpt.get();

      compteSource.setSolde(compteSource.getSolde() - requestDTO.getMontant());
      compteRepository.save(compteSource);

      compteDestination.setSolde(compteDestination.getSolde() + requestDTO.getMontant());
      compteRepository.save(compteDestination);
    }
  }
}
