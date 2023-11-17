package com.example.spring.controllers;

import com.example.spring.models.Basic;
import com.example.spring.services.BasicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//* To create an API, just replace "@Controller" with "@RestController"
@RestController

@RequestMapping("/api")
public class BasicAPI {
    private final BasicService basicService;

    public BasicAPI(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("/basics")

    //* Instead of returning a JSP view, we just return the objects.
    public List<Basic> getBasics() {
        return basicService.findAll();
    }
}
