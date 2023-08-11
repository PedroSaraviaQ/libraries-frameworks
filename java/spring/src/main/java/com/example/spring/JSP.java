package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//* In order to use JSP, you need to add the following dependencies:
//* tomcat-embed-jasper, jakarta.servlet.jsp.jstl (from glassfish), jakarta.servlet.jsp.jstl-api (from jakarta)

//* Create "webapp/WEB-INF" folder inside "main" to store the JSP files
//* And write "spring.mvc.view.prefix=/WEB-INF/" in the "application.properties" file

@Controller
public class JSP {

    //* Then you can just return the name of the JSP file as a String.
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
