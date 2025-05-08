package de.vasile.ueberstunden.service;

import de.vasile.ueberstunden.entity.Ueberstunde;
import de.vasile.ueberstunden.repository.UeberstundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UeberstundeService {

    @Autowired
    private UeberstundeRepository ueberstundeRepository;

    // Neue Überstunde speichern
    public Ueberstunde saveUeberstunde(Ueberstunde ueberstunde) {
        return ueberstundeRepository.save(ueberstunde);
    }

    // Alle Überstunden abrufen
    public List<Ueberstunde> findAllUeberstunden() {
        return ueberstundeRepository.findAll();
    }

    // Eine Überstunde anhand der ID abrufen
    public Optional<Ueberstunde> findUeberstundeById(Long id) {
        return ueberstundeRepository.findById(id);
    }

    // Eine Überstunde anhand der ID löschen
    public void deleteUeberstundeById(Long id) {
        ueberstundeRepository.deleteById(id);
    }
}