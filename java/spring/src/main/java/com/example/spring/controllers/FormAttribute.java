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

//* The "@ModelAttribute" annotation is used when we have a lot of data to handle.

@Controller
@RequestMapping("/model")
public class FormAttribute {
    private final BasicService basicService;

    public FormAttribute(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("")
    //* Even if the method doesn't use the model attribute, it must be passed if JSP file uses it.
    public String form(Model model, @ModelAttribute("basic") Basic basic) {
        List<Basic> basics = basicService.findAll();
        model.addAttribute("basics", basics);
        return "formModel.jsp";
    }

    @PostMapping("")
    //* It's not obligatory, but if you want to handle errors, you must add
    //* The "@Valid" annotation to the model attribute and the "BindingResult" parameter.
    public String create(@Valid @ModelAttribute("basic") Basic basic, BindingResult result) {
        //* To check if there are errors, use the "hasErrors" method.
        if (result.hasErrors()) {
            //* Then return the view that will show the errors.
            return "formModel.jsp";
        }
        //* If not, then save and redirect as a normal post method.
        basicService.save(basic);
        return "redirect:/model";
    }

    @GetMapping("/{id}")
    //* In this case, we're replacing the use of the model attribute with the model itself.
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
