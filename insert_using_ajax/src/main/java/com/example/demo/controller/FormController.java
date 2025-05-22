package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showForm() {
        return "form"; // refers to templates/form.html
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam int age, @RequestParam long mobile) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setmobile(mobile); // Changed to match Java naming
        userRepository.save(user);
        return "redirect:/"; // redirect to form again
    }

    @GetMapping("/view")
    public String viewDetails(Model model) {
        model.addAttribute("data", userRepository.findAll());
        return "view"; // refers to templates/view.html
    }
}
