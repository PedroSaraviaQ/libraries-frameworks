package com.example.spring.services;

import com.example.spring.models.User;
import com.example.spring.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class UserService extends SuperService<User> {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
    
    public void register(User user, HttpSession session) {
        
        //* Before saving the user, we need to encrypt their password
        //* Using BCrypt's "hashpw" and "gensalt" methods
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        
        //* Then we set their password, and finally save the user
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        
        //* You can also add the user to the session for protected routes
        session.setAttribute("id", user.getId());
    }
    
    public boolean login(String email, String password, HttpSession session, RedirectAttributes redirectAttributes) {
        
        //* We find the user by their email
        User user = userRepository.findByEmail(email);
        
        redirectAttributes.addFlashAttribute("email", email);
        redirectAttributes.addFlashAttribute("password", password);
        
        //* If the user doesn't exist, or the password is incorrect by using BCrypt's "checkpw" method
        //* Then we return false as the login was unsuccessful
        if (user == null) {
            redirectAttributes.addFlashAttribute("emailError", "Email not found");
            return false;
        }
        if (!BCrypt.checkpw(password, user.getPassword())) {
            redirectAttributes.addFlashAttribute("passwordError", "Incorrect password");
            return false;
        }
        
        //* If the user is found and the password is correct, we return true
        //* And we can additionally add the user to the session
        session.setAttribute("id", user.getId());
        return true;
    }
}
