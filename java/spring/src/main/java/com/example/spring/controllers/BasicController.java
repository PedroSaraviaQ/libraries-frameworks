package com.example.spring.controllers;

import com.example.spring.models.Basic;
import com.example.spring.services.BasicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/basic")
public class BasicController {

    //* This is a dependency injection of the service
    private final BasicService basicService;

    //* The constructor is used to inject the service
    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("")
    public String basics(Model model) {

        //* The elements are retrieved from the database using the service
        List<Basic> basics = basicService.findAll();

        //* And then they can just be added to the model
        model.addAttribute("basics", basics);

        return "basic.jsp";
    }

    @PostMapping("")
    public String saveBasic(
            @RequestParam String name, @RequestParam String password,
            @RequestParam String email, @RequestParam Integer age
    ) {
        try {
            //* Create a new basic object
            Basic basic = new Basic();

            //* Add the form data to the object
            basic.setName(name);
            basic.setEmail(email);
            basic.setPassword(password);
            basic.setAge(age);

            //* And then save it using the service
            basicService.save(basic);

        } catch (IllegalArgumentException e) {
            //* If something goes wrong, you can handle the exception here
        }
        return "redirect:/basic";
    }
}