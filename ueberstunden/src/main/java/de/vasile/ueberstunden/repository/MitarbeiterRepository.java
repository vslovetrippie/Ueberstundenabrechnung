package de.vasile.ueberstunden.repository;

import de.vasile.ueberstunden.entity.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {
}