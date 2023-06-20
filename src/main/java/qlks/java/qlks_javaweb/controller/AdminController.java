package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qlks.java.qlks_javaweb.model.User;
import qlks.java.qlks_javaweb.service.RoleService;
import qlks.java.qlks_javaweb.service.RoomService;
import qlks.java.qlks_javaweb.service.UserService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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
            model.addAttribute("allRoles",roleService.getAllRoles() ); // Assuming allRoles is a list of available roles
            return "admin/users/edit-user";
        } else {
            return "redirect:/admin/users";
        }
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable Integer userId, @ModelAttribute("user") User updatedUser) {
        userService.updateUser(userId, updatedUser);
        return "redirect:/admin/users/userprofile";
    }



    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/users";
    }
    @GetMapping("/ad")
    public String showad(){
        return "admin/adminprofile";// test admin
    }


}
