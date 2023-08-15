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
    //* If you want to pass a variable to the JSP, you can use the
    //* "Model" class by passing as a parameter to the method
    public String variable(Model model) {

        //* Then you can use the "addAttribute" method to pass the variable
        //* The arguments would be the name of the variable as String and the value.
        model.addAttribute("name", "Pedro");

        //* You can also pass a bean as a variable
        //? But the class must be public when working with JSP files (not sure why)
        BeanJSP animal = new BeanJSP();
        animal.setName("cat");
        animal.setColor("black");

        //* Just pass the object as the value
        model.addAttribute("animal", animal);

        return "variable.jsp";
    }
}

//* Another use of "@Controller" is to handle forms with POST requests.
@Controller
class Forms {

    //* To retrieve the data from the form, you can use the "@RequestParam" annotation
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           HttpSession session, RedirectAttributes redirectAttributes) {

        //* Optionally, you can print the values to the console to check if it's working.
        System.out.println(username + ": " + password);

        //* If you want to have the values in different routes, you can use sessions to store them.
        session.setAttribute("username", username);

        //* If for some reason you want access to the session, you can get it by casting them.
        //! Be careful, use wrapper classes instead of primitives here too.
        String user = (String) session.getAttribute("username");

        //* Remember to remove the session variables when you don't need them anymore.
        //! Because if you don't, the values will be stored in the session until it expires.
        // session.removeAttribute("username");

        //* Flash attributes are similar to sessions, but they only last for the next request.
        redirectAttributes.addFlashAttribute("message", "Congratulations!");

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
