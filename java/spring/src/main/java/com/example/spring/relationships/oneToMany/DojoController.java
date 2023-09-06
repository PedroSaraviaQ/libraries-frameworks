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
@RequestMapping("/dojos")
public class DojoController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("")
    public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
        List<Dojo> dojos = dojoService.findAll();
        List<Ninja> ninjas = ninjaService.findAll();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninjas", ninjas);
        return "rships/dojos.jsp";
    }

    @PostMapping("")
    public String create(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/dojos.jsp";
        }
        dojoService.save(dojo);
        return "redirect:/dojos";
    }
}
