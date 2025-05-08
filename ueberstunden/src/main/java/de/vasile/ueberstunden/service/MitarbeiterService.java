package de.vasile.ueberstunden.service;

import de.vasile.ueberstunden.entity.Mitarbeiter;
import de.vasile.ueberstunden.repository.MitarbeiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MitarbeiterService {

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    // Einen neuen Mitarbeitenden speichern
    public Mitarbeiter saveMitarbeiter(Mitarbeiter mitarbeiter) {
        return mitarbeiterRepository.save(mitarbeiter);
    }

    // Alle Mitarbeitenden abrufen
    public List<Mitarbeiter> findAllMitarbeiter() {
        return mitarbeiterRepository.findAll();
    }

    // Einen Mitarbeitenden anhand der ID finden
    public Optional<Mitarbeiter> findMitarbeiterById(Long id) {
        return mitarbeiterRepository.findById(id);
    }

    // Einen Mitarbeitenden anhand der ID löschen
    public void deleteMitarbeiterById(Long id) {
        mitarbeiterRepository.deleteById(id);
    }
    
    public Mitarbeiter findeNachId(Long id) {
        return mitarbeiterRepository.findById(id).orElse(null);
    }
}