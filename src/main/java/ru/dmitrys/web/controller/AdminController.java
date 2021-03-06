package ru.dmitrys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dmitrys.web.model.User;
import ru.dmitrys.web.service.RoleService;
import ru.dmitrys.web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(defaultValue = "") String adminRole) {
        userService.saveUser(user, adminRole);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updatePage(Model model, @RequestParam("login") String login) {
        model.addAttribute("user", userService.getUser(login));
        return "update";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(defaultValue = "") String adminRole) {
        userService.updateUser(user, adminRole);
        return "redirect:/admin";
    }

    @DeleteMapping()
    public String deleteUser(@RequestParam("login") String login) {
        userService.deleteUser(login);
        return "redirect:/admin";
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("user", new User());
    }
}
