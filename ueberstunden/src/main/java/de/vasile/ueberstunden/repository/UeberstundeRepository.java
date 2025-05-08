package de.vasile.ueberstunden.repository;

import de.vasile.ueberstunden.entity.Ueberstunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UeberstundeRepository extends JpaRepository<Ueberstunde, Long> {
}