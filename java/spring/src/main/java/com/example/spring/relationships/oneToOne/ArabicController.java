package com.example.spring.relationships.oneToOne;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/arabics")
public class ArabicController {
    @Autowired private ArabicService arabicService;
    @Autowired private RomanService romanService;

    @GetMapping("")
    public String index(@ModelAttribute("arabic") Arabic arabic, Model model) {
        List<Arabic> arabics = arabicService.findAll();
        model.addAttribute("arabics", arabics);
        return "rships/arabics.jsp";
    }

    @PostMapping("")
    public String create(@Valid @ModelAttribute Arabic arabic, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/arabics.jsp";
        }

        //* In order to save the Arabic object, we need to save the Roman object first
        //* That's performed by using the getter of the arabic.
        romanService.save(arabic.getRoman());

        //* Then we normally save the arabic.
        arabicService.save(arabic);

        return "redirect:/arabics";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Arabic arabic = arabicService.findById(id);
        model.addAttribute("arabic", arabic);
        return "rships/arabic.jsp";
    }

    @PutMapping("/{id}")
    public String update(@Valid @ModelAttribute Arabic arabic, BindingResult result) {
        if (result.hasErrors()) {
            return "rships/arabic.jsp";
        }

        //* The same goes for the update method.
        romanService.save(arabic.getRoman());
        arabicService.save(arabic);

        return "redirect:/arabics";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        //* When deleting the arabic, the roman will be deleted as well because of the cascade.
        arabicService.deleteById(id);

        return "redirect:/arabics";
    }
}
