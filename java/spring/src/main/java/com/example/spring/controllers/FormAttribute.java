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

    //* Add it to the view to instantiate an empty object and link it to the form.
    public String form(Model model, @ModelAttribute Basic basic) {

        //! The annotation has an argument to specify the name of the object in the view.
        //! You must include it if the name of the object is different from the class name.
        // @ModelAttribute("basic") NewBasic basic

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

        //* If no errors are present, save the form data as an object and redirect as usual.
        basicService.save(basic);
        return "redirect:/model";
    }

    //* To update, the process is nearly the same as creating. Just pass the ID in the path.
    @PostMapping("/{id}")

    //! "@PathVariable" is not needed as the ID is automatically consumed by the object.
    public String update(@Valid @ModelAttribute Basic basic, BindingResult result) {
        if (result.hasErrors()) {
            return "formModel.jsp";
        }

        //* The only difference in the method is the name for the service method.
        basicService.update(basic);

        return "redirect:/model";
    }

    //* To delete, you could use the ID in the path.
    @PostMapping("/{id}/delete")

    //! Since no object is passed, "@PathVariable" is needed to capture the ID.
    public String delete(@PathVariable Integer id) {

        //* Just pass the ID as an argument to the service method.
        basicService.deleteById(id);

        return "redirect:/model";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        Basic basic = basicService.findById(id);
        model.addAttribute("basic", basic);
        return "updateAndDelete.jsp";
    }

    //! You can still however use "@PutMapping" and "@DeleteMapping" to handle the requests.
}
