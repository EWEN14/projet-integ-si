package org.si.projetintegsi;

import org.si.projetintegsi.entities.Compte;
import org.si.projetintegsi.entities.enums.TypeCompte;
import org.si.projetintegsi.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ProjetIntegSiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjetIntegSiApplication.class, args);
  }

  @Bean
  CommandLineRunner start(CompteRepository compteRepository) {
    return args -> {
      compteRepository.save(new Compte(null, 98800.0, LocalDate.now(), TypeCompte.COURANT));
      compteRepository.save(new Compte(null, 12000.0, LocalDate.now(), TypeCompte.COURANT));
      compteRepository.save(new Compte(null, 2100.0, LocalDate.now(), TypeCompte.COURANT));
      compteRepository.findAll().forEach(compte -> {
        System.out.println(compte.getType() + " : " + compte.getSolde());
      });
    };
  }
}
