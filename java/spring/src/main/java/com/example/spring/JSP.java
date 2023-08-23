package com.example.spring;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    //* If you want to pass a variable to the JSP, you can use the "Model" class
    public String variable(Model model) {

        //* Then use the "addAttribute" method to pass the variable (name, value)
        model.addAttribute("name", "Pedro");

        //* You can also pass a bean as a variable
        //? But the class must be public when working with JSP files (not sure why)
        BeanJSP animal = new BeanJSP();
        animal.setName("cat");
        animal.setColor("black");

        model.addAttribute("animal", animal);
        return "variable.jsp";
    }
}

@Controller
class Forms {

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           HttpSession session, RedirectAttributes redirectAttributes) {

        //* To retrieve the data from the form, use the "@RequestParam" annotation
        //! The default value for inputs is "" instead of null, so it's best to use String here.
        // TODO: you can print the values to the console to check if it's working.
        System.out.println(username + ": " + password);

        //* If you want to have values in different routes, you can use the "HttpSession" class
        //* With the "setAttribute" method, you store the values in the session.
        session.setAttribute("username", username);

        //* To access the value, use the "getAttribute" and cast it to the correct type.
        //! Be careful, use wrapper classes because the value could be null.
        String user = (String) session.getAttribute("username");

        //* To remove the value from the session, use the "removeAttribute" method.
        //! Remember to remove the value when you don't need it anymore.
        // session.removeAttribute("username");

        //* If you want to store a value only for the next request, use the "RedirectAttributes" class
        //* Use the "addFlashAttribute" method to store the value.
        redirectAttributes.addFlashAttribute("message", "Congratulations!");

        //* To return a JSP file after a POST request, you need to use the "redirect" keyword
        //! If you do it without it, the POST request will be repeated if the user refreshes the page.
        return "redirect:/welcome";
    }

    //* This is the route that will be called after the POST request
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome.jsp";
    }
}
