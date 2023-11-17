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
        
        //* When creating a new musician, we don't include any instruments yet.
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
        
        //* Because our form uses ModelAttribute, but doesn't include the instruments field,
        //* we need to retrieve the instruments from the database and set them back on the musician.
        musician.setInstruments(musicianService.findById(musician.getId()).getInstruments());
        
        //* Then we can save it as usual.
        musicianService.save(musician);
        
        return "redirect:/musicians";
    }
    
    @PutMapping("/{id}/instruments")
    
    //* To add an instrument to a musician, we retrieve its id as a request parameter.
    public String updateInstruments(@PathVariable("id") Long musicianId, @RequestParam Long instrumentId) {
        
        //* We find both the musician and the instrument.
        Musician musician = musicianService.findById(musicianId);
        Instrument instrument = instrumentService.findById(instrumentId);
        
        //* Then we add the instrument to the musician's set of instruments.
        Set<Instrument> instruments = musician.getInstruments();
        instruments.add(instrument);
        
        //* And finally, we save the musician.
        musician.setInstruments(instruments);
        musicianService.save(musician);
        
        return "redirect:/musicians/" + musicianId;
    }
    
    @DeleteMapping("/{id}/instruments")
    
    //* The process for removing an instrument is similar.
    public String deleteInstruments(@PathVariable("id") Long musicianId, @RequestParam Long instrumentId) {
        Musician musician = musicianService.findById(musicianId);
        Instrument instrument = instrumentService.findById(instrumentId);
        Set<Instrument> instruments = musician.getInstruments();
        
        //* Instead of adding the instrument, we remove it from the set.
        instruments.remove(instrument);
        
        musician.setInstruments(instruments);
        musicianService.save(musician);
        
        return "redirect:/musicians/" + musicianId;
    }
    
    @DeleteMapping("/{id}")
    public String deleteMusician(@PathVariable Long id) {
        
        //* When deleting a musician, the instruments also delete the musician from their set.
        musicianService.deleteById(id);
        
        return "redirect:/musicians";
    }
}
