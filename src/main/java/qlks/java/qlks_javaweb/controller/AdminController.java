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
}
