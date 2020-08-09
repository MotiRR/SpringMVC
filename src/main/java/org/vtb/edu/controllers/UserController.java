package org.vtb.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vtb.edu.database.dto.User;
import org.vtb.edu.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllBoxes(Model model) {
        model.addAttribute("frontUsers", userService.getAllUsers());
        return "all_users";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping({"/user/{id}", "/user"})
    public String showUser(@PathVariable(required = false) Long id, Model model) {
        if (id == null) id = 0L;
        User user = userService.getUserById(id);
        model.addAttribute("frontUser", user);
        return "user";
    }
}
