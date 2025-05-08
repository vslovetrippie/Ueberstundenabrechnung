package de.vasile.ueberstunden.controller;

import de.vasile.ueberstunden.entity.Mitarbeiter;
import de.vasile.ueberstunden.service.MitarbeiterService;
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
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    @Autowired
    private MitarbeiterService mitarbeiterService;
    
    // 1. Liste aller Mitarbeitenden anzeigen
    @GetMapping
    public String listMitarbeiter(Model model) {
        List<Mitarbeiter> mitarbeitende = mitarbeiterService.findAllMitarbeiter();
        model.addAttribute("mitarbeitende", mitarbeitende);
        return "mitarbeiter/list";
    }

    // 2. Formular zum Anlegen anzeigen
    @GetMapping("/neu")
    public String showCreateForm(Model model) {
        model.addAttribute("mitarbeiter", new Mitarbeiter());
        return "mitarbeiter/form"; 
    }

    // 3. Mitarbeitende speichern
    @PostMapping("/speichern")
    public String saveMitarbeiter(@ModelAttribute Mitarbeiter mitarbeiter) {
        mitarbeiterService.saveMitarbeiter(mitarbeiter);
        return "redirect:/mitarbeiter";
    }
    // 4. Mitarbeitende bearbeiten
    @GetMapping("/bearbeiten/{id}")
    public String mitarbeiterBearbeiten(@PathVariable Long id, Model model) {
        Mitarbeiter mitarbeiter = mitarbeiterService.findeNachId(id);
        model.addAttribute("mitarbeiter", mitarbeiter);
        return "mitarbeiter/form";
    }

    // 5. Mitarbeitende löschen
    @GetMapping("/loeschen/{id}")
    public String deleteMitarbeiter(@PathVariable Long id) {
        mitarbeiterService.deleteMitarbeiterById(id);
        return "redirect:/mitarbeiter";
    }
}