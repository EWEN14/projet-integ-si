package org.si.projetintegsi.repositories;

import org.si.projetintegsi.entities.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoordonneesRepository extends JpaRepository<Coordonnees, Long> {
}
