package com.example.spring.controllers;

import com.example.spring.models.SubModel;
import com.example.spring.services.SubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//* The controller doesn't need any changes.

@Controller
@RequestMapping("/sub")
public class SubController {
    private final SubService subService;

    public SubController(SubService subService) {
        this.subService = subService;
    }

    //* In the service however, you can use "@Autowired" whatsoever.
    // @Autowired private SubService subService;

    @GetMapping("")
    public String sub(Model model) {
        List<SubModel> subs = subService.findAll();
        model.addAttribute("subs", subs);
        return "sub.jsp";
    }

    @PostMapping("")
    public String postSub(@RequestParam String name, @RequestParam String code) {
        try {
            SubModel subModel = new SubModel();
            subModel.setName(name);
            subModel.setCode(code);
            subService.save(subModel);
        } catch (IllegalArgumentException e) {

        }
        return "redirect:/sub";
    }

    @GetMapping("/{id}")
    public String getSub(@PathVariable Long id, Model model) {
        SubModel sub = subService.findById(id);
        model.addAttribute("sub", sub);
        return "subItem.jsp";
    }

    @PutMapping("/{id}")
    public String getSub(@Valid @ModelAttribute("sub") SubModel sub, BindingResult result) {
        if (result.hasErrors()) {
            return "subItem.jsp";
        }
        subService.save(sub);
        return "redirect:/sub";
    }

    @DeleteMapping("/{id}")
    public String deleteSub(@PathVariable Long id) {
        subService.deleteById(id);
        return "redirect:/sub";
    }
}
