package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qlks.java.qlks_javaweb.model.User;
import qlks.java.qlks_javaweb.service.UserService;

import java.util.List;
import java.util.Optional;

@RequestMapping("admin")
@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public String index()// test trang admin
    {
        return "admin/index";
    }
    @GetMapping("/employee")
    public  String showem()
    {
        return "admin/employee";
    }
    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users/userprofile";
    }

    @GetMapping("/users/{userId}")
    public String showUserDetails(@PathVariable Integer userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/users/user-details";
        } else {
            return "redirect:/admin/users/userprofile";
        }
    }

    @GetMapping("/users/{userId}/edit")
    public String editUserForm(@PathVariable Integer userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/users/edit-user";
        } else {
            return "redirect:/admin/users/userprofile";
        }
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable Integer userId, @ModelAttribute("user") User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);
        return "redirect:/admin/users/userprofile" + user.getUser_id();
    }

    @PostMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/users/userprofile";
    }
    @GetMapping("/ad")
    public String showad(){
        return "admin/adminprofile";// test admin
    }
}
