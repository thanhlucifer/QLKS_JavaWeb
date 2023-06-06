package qlks.java.qlks_javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin")
@Controller
public class AdminController {
    @GetMapping("")
    public String index()// test trang admin
    {
        return "admin/index";
    }

    @GetMapping("/employee")
    public String showEmployee(){
        return "admin/employee";// test employee
    }
    @GetMapping("/userprofile")
    public String showuser(){
        return "admin/userprofile";// test user
    }
    @GetMapping("/ad")
    public String showad(){
        return "admin/adminprofile";// test admin
    }
}
