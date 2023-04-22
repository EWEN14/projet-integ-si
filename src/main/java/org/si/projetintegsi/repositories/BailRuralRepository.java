package org.si.projetintegsi.repositories;

import org.si.projetintegsi.entities.BailRural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BailRuralRepository extends JpaRepository<BailRural, Long> {
}
