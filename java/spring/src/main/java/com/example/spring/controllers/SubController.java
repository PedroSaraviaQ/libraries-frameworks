package com.example.spring.controllers;

import com.example.spring.models.SubModel;
import com.example.spring.services.SubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//* Then the rest works the same way as a normal controller.

@Controller
@RequestMapping("/sub")
public class SubController {
    private final SubService subService;

    public SubController(SubService subService) {
        this.subService = subService;
    }

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
}
