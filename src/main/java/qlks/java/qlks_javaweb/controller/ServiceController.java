package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import qlks.java.qlks_javaweb.model.Service;
import qlks.java.qlks_javaweb.service.ServiceService;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/admin/service")
    public String showService(Model model){
        model.addAttribute("listService",serviceService.GetAll());
        return "admin/service/index";
    }

    @GetMapping("/admin/service/create")
    public String create(Model model){
        Service service = new Service();
        model.addAttribute("service",service);
        return "admin/service/create";
    }

    @PostMapping("/admin/service/save")
    public String saveService(@ModelAttribute("service") Service service) {
        serviceService.save(service);
        return "redirect:/admin/service";
    }

    @GetMapping("/admin/service/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        this.serviceService.remove(id);
        return "redirect:/admin/service";

    }
}
