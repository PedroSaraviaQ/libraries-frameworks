package com.example.spring.relationships.oneToMany;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;
    
    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    
    @GetMapping("")
    public String index(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Ninja> ninjas = ninjaService.findAll();
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojos", dojos);
        return "rships/ninjas.jsp";
    }
    
    @PostMapping("")
    public String create(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/ninjas.jsp";
        }
        
        //* When creating the ninja, the dojo saves the ninja to its list.
        ninjaService.save(ninja);
        
        return "redirect:/ninjas";
    }
    
    @GetMapping("/{id}")
    public String getNinja(@PathVariable Long id, Model model) {
        Ninja ninja = ninjaService.findById(id);
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("ninja", ninja);
        model.addAttribute("dojos", dojos);
        return "rships/ninja.jsp";
    }
    
    @PostMapping("/{id}")
    public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/ninja.jsp";
        }
        
        //* The same goes for updating the ninja.
        ninjaService.save(ninja);
        
        return "redirect:/ninjas";
    }
    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        
        //* When deleting the ninja, the dojo also deletes the ninja from its list.
        ninjaService.deleteById(id);
        
        return "redirect:/ninjas";
    }
}
