package com.example.spring.relationships.manyToMany;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {
    @Autowired InstrumentService instrumentService;
    
    @GetMapping("")
    public String index(@ModelAttribute("instrument") Instrument instrument, Model model) {
        List<Instrument> instruments = instrumentService.findAll();
        model.addAttribute("instruments", instruments);
        return "rships/instruments.jsp";
    }
    
    @PostMapping("")
    public String createInstrument(@Valid @ModelAttribute Instrument instrument, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return index(instrument, model);
        }
        instrumentService.save(instrument);
        return "redirect:/instruments";
    }
    
    @GetMapping("/{id}")
    public String showInstrument(@PathVariable Long id, Model model) {
        Instrument instrument = instrumentService.findById(id);
        model.addAttribute("instrument", instrument);
        return "rships/instrument.jsp";
    }
    
    @PutMapping("/{id}")
    public String updateInstrument(@Valid @ModelAttribute Instrument instrument, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/instrument.jsp";
        }
        
        //* Updating an instrument will also update the musician's instruments
        instrumentService.save(instrument);
        
        return "redirect:/instruments";
    }
    
    @DeleteMapping("/{id}")
    public String deleteInstrument(@PathVariable Long id) {
        
        //! You can't delete an instrument if it's still being used by a musician.
        instrumentService.deleteById(id);
        
        return "redirect:/instruments";
    }
}
