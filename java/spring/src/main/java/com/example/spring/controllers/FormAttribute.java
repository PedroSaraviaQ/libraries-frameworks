package com.example.spring.controllers;

import com.example.spring.models.Basic;
import com.example.spring.services.BasicService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//* "@ModelAttribute" is an easier way to handle forms.

//* Instead of passing the "Model" class, you can pass the object itself with the annotation.

@Controller
@RequestMapping("/model")
public class FormAttribute {
    private final BasicService basicService;

    public FormAttribute(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("")

    //* Add it to the view to instantiate an empty object.
    public String form(Model model, @ModelAttribute Basic basic) {

        //! This code has anything to do with ModelAttribute, it's just to show a list of all the objects.
        List<Basic> basics = basicService.findAll();
        model.addAttribute("basics", basics);

        return "formModel.jsp";
    }

    @PostMapping("")

    //* To handle submission errors, add "@Valid" to the object and include "BindingResult" as a parameter.
    public String create(@Valid @ModelAttribute Basic basic, BindingResult result) {

        //* "hasErrors" is used to check for errors related to model constraints.
        if (result.hasErrors()) {

            //* If errors are present, return the view to display the error messages.
            return "formModel.jsp";

        }

        //* If no errors are present, save the form data as an object and redirect as normal.
        basicService.save(basic);
        return "redirect:/model";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        Basic basic = basicService.findById(id);
        model.addAttribute("basic", basic);
        return "updateAndDelete.jsp";
    }

    //* When we want to update, we need to pass the id in the path in order to find the object.
    @PostMapping("/{id}")
    public String update(@Valid @ModelAttribute("basic") Basic basic, BindingResult result) {
        if (result.hasErrors()) {
            return "formModel.jsp";
        }
        basicService.update(basic);
        return "redirect:/model";
    }

    //* We can also delete an object, and then redirect to another page.
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        basicService.deleteById(id);
        return "redirect:/model";
    }
}
