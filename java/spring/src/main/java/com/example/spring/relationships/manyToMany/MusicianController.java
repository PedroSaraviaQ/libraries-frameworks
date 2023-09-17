package com.example.spring.relationships.manyToMany;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/musicians")
public class MusicianController {
    @Autowired MusicianService musicianService;
    @Autowired InstrumentService instrumentService;
    
    @GetMapping("")
    public String index(@ModelAttribute("musician") Musician musician, Model model) {
        List<Musician> musicians = musicianService.findAll();
        model.addAttribute("musicians", musicians);
        return "rships/musicians.jsp";
    }
    
    @PostMapping("")
    public String newMusician(@Valid @ModelAttribute("musician") Musician musician, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return index(musician, model);
        }
        musicianService.save(musician);
        return "redirect:/musicians";
    }
    
    @GetMapping("/{id}")
    public String showMusician(@PathVariable Long id, Model model) {
        Musician musician = musicianService.findById(id);
        List<Instrument> instruments = instrumentService.findAll();
        model.addAttribute("musician", musician);
        model.addAttribute("instruments", instruments);
        return "rships/musician.jsp";
    }
    
    @PutMapping("/{id}")
    public String updateMusician(@Valid @ModelAttribute Musician musician, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Instrument> instruments = instrumentService.findAll();
            model.addAttribute("instruments", instruments);
            return "rships/musician.jsp";
        }
        musician.setInstruments(musicianService.findById(musician.getId()).getInstruments());
        musicianService.save(musician);
        return "redirect:/musicians";
    }
    
    @PutMapping("/{id}/instruments")
    public String updateInstruments(@PathVariable("id") Long musicianId, @RequestParam Long instrumentId) {
        Musician musician = musicianService.findById(musicianId);
        Instrument instrument = instrumentService.findById(instrumentId);
        Set<Instrument> instruments = musician.getInstruments();
        
        instruments.add(instrument);
        musician.setInstruments(instruments);
        musicianService.save(musician);
        
        return "redirect:/musicians/" + musicianId;
    }
    
    @DeleteMapping("/{id}/instruments")
    public String deleteInstruments(@PathVariable("id") Long musicianId, @RequestParam Long instrumentId) {
        Musician musician = musicianService.findById(musicianId);
        Instrument instrument = instrumentService.findById(instrumentId);
        Set<Instrument> instruments = musician.getInstruments();
        
        instruments.remove(instrument);
        musician.setInstruments(instruments);
        musicianService.save(musician);
        
        return "redirect:/musicians/" + musicianId;
    }
}
