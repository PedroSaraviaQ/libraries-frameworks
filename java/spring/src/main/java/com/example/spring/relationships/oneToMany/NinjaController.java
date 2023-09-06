package com.example.spring.relationships.oneToMany;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        ninjaService.save(ninja);
        return "redirect:/ninjas";
    }
}
