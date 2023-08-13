package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//* In order to use JSP, you need to add the following dependencies:
//* tomcat-embed-jasper, jakarta.servlet.jsp.jstl (from glassfish), jakarta.servlet.jsp.jstl-api (from jakarta)

//* Create "webapp/WEB-INF" folder inside "main" to store the JSP files
//* And write "spring.mvc.view.prefix=/WEB-INF/" in the "application.properties" file

//* The "@Controller" annotation is used to return JSP files
@Controller
public class JSP {

    //* You can just return the name of the JSP file as a String.
    @RequestMapping("/home")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/variable")
    //* If you want to pass a variable to the JSP, you can use the
    //* "Model" class by passing as a parameter to the method
    public String variable(Model model) {

        //* Then you can use the "addAttribute" method to pass the variable
        //* The arguments would be the name of the variable as String and the value.
        model.addAttribute("name", "Pedro");

        return "variable.jsp";
    }
}

//* Another use of "@Controller" is to handle forms with POST requests.
@Controller
class Forms {

    //* To retrieve the data from the form, you can use the "@RequestParam" annotation
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {

        //* Optionally, you can print the values to the console to check if it's working.
        System.out.println(username + ": " + password);

        //* If you want to return a JSP file after a POST request, you need to use the "redirect" keyword
        return "redirect:/welcome";
        //! While it's possible to do it without "redirect", it's not recommended
        //! because it can repeat the POST request if the user refreshes the page.
    }

    //* This is the route that will be called after the POST request
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome.jsp";
    }
}
