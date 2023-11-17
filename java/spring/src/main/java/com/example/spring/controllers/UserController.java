package com.example.spring.controllers;

import com.example.spring.models.User;
import com.example.spring.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;
    
    @GetMapping("/register")
    public String newUser(@ModelAttribute("user") User user) {
        return "encrypt/register.jsp";
    }
    
    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session) {
        
        //* This code is just to check if the passwords match, if not, we add an error to the result
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            FieldError error = new FieldError("confirmPassword", "confirmPassword", "Passwords must match");
            result.addError(error);
        }
        
        //* Then we check the errors (including the password match) if there are any, as usual
        if (result.hasErrors()) {
            return "encrypt/register.jsp";
        }
        
        //* Then we encrypt the password and save the user
        userService.register(user, session);
        
        return "redirect:/users";
    }
    
    @GetMapping("")
    public String home() {
        return "encrypt/home.jsp";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        
        //* We call the login method to check the email and password and see if it was successful
        if (!userService.login(email, password, session, redirectAttributes)) {
            
            return "redirect:/users";
        }
        return "redirect:/users/me";
    }
    
    @GetMapping("/me")
    public String userDetails(Model model, HttpSession session) {
        
        //* This code is just for protecting the route, if it's not logged in, we redirect to the login page
        if (session.getAttribute("id") == null) {
            return "redirect:/users";
        }
        
        //* This is another way to retrieve the user, using the session
        User user = userService.findById((Long) session.getAttribute("id"));
        
        model.addAttribute("user", user);
        return "encrypt/user.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        
        //* This destroys the session and all its attributes
        session.invalidate();
        
        //* Then we can redirect to the login page
        return "redirect:/users";
    }
}
