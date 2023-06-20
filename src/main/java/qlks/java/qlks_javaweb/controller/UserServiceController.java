package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qlks.java.qlks_javaweb.service.ServiceService;

@Controller
@RequestMapping("home/service")
public class UserServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    public String list(Model model)
    {
        model.addAttribute("services", serviceService.getAll());
        return "user/service";
    }
}
