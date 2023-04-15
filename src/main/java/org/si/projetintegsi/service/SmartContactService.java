package org.si.projetintegsi.service;

import org.si.projetintegsi.repositories.SmartContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartContactService {

  private SmartContratRepository smartContratRepository;

  @Autowired
  public void setCompteRepository(SmartContratRepository compteRepository) {
    this.smartContratRepository = compteRepository;
  }
}
