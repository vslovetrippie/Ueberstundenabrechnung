package de.vasile.ueberstunden.controller;

import de.vasile.ueberstunden.entity.Mitarbeiter;
import de.vasile.ueberstunden.entity.Ueberstunde;
import de.vasile.ueberstunden.service.MitarbeiterService;
import de.vasile.ueberstunden.service.UeberstundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ueberstunden")
public class UeberstundeController {

    @Autowired
    private UeberstundeService ueberstundeService;

    @Autowired
    private MitarbeiterService mitarbeiterService;

    // 1. Alle Überstunden anzeigen
    @GetMapping
    public String listUeberstunden(Model model) {
        List<Ueberstunde> ueberstunden = ueberstundeService.findAllUeberstunden();
        model.addAttribute("ueberstunden", ueberstunden);
        return "ueberstunde/list";
    }

    // 2. Formular für neue Überstunde anzeigen
    @GetMapping("/neu")
    public String showCreateForm(Model model) {
        model.addAttribute("ueberstunde", new Ueberstunde());
        List<Mitarbeiter> mitarbeitende = mitarbeiterService.findAllMitarbeiter();
        model.addAttribute("mitarbeitende", mitarbeitende);
        return "ueberstunde/form";
    }

    // 3. Neue Überstunde speichern
    @PostMapping
    public String saveUeberstunde(@ModelAttribute Ueberstunde ueberstunde) {
        ueberstundeService.saveUeberstunde(ueberstunde);
        return "redirect:/ueberstunden";
    }
    // 4. Überstunde bearbeiten
    @GetMapping("/bearbeiten/{id}")
    public String bearbeiteUeberstunde(@PathVariable Long id, Model model) {
        Ueberstunde ueberstunde = ueberstundeService.findUeberstundeById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ungültige ID: " + id));

        model.addAttribute("ueberstunde", ueberstunde);
        model.addAttribute("mitarbeitende", mitarbeiterService.findAllMitarbeiter());
        return "ueberstunde/form";
    }

    // 5. Überstunde löschen
    @GetMapping("/loeschen/{id}")
    public String deleteUeberstunde(@PathVariable Long id) {
        ueberstundeService.deleteUeberstundeById(id);
        return "redirect:/ueberstunden";
    }
    
    @GetMapping("/neu/{mitarbeiterId}")
    public String ueberstundeFuerMitarbeiter(@PathVariable Long mitarbeiterId, Model model) {
        Ueberstunde ueberstunde = new Ueberstunde();

        mitarbeiterService.findMitarbeiterById(mitarbeiterId).ifPresent(ueberstunde::setMitarbeiter);

        model.addAttribute("ueberstunde", ueberstunde);
        model.addAttribute("mitarbeitende", mitarbeiterService.findAllMitarbeiter());

        return "ueberstunde/form";
    }
}