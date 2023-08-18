package com.example.spring.controllers;

import com.example.spring.models.Basic;
import com.example.spring.services.BasicService;
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
@RequestMapping("/model")
public class FormAttribute {
    private final BasicService basicService;

    public FormAttribute(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("")
    //* Even if the method doesn't use the model attribute, it must be passed if JSP file uses it.
    public String form(Model model, @ModelAttribute Basic basic) {
        List<Basic> basics = basicService.findAll();
        model.addAttribute("basics", basics);
        return "formModel.jsp";
    }

    @PostMapping("")
    //* It's not obligatory, but if you want to handle errors, you must add
    //* The "@Valid" annotation to the model attribute and the "BindingResult" parameter.
    public String create(@Valid @ModelAttribute Basic basic, BindingResult result) {
        //* To check if there are errors, use the "hasErrors" method.
        if (result.hasErrors()) {
            //* Then return the view that will show the errors.
            return "formModel.jsp";
        }
        //* If not, then save and redirect as a normal post method.
        basicService.save(basic);
        return "redirect:/model";
    }
}
