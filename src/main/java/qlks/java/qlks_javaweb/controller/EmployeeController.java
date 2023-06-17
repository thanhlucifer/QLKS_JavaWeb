package qlks.java.qlks_javaweb.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qlks.java.qlks_javaweb.model.Employee;
import qlks.java.qlks_javaweb.model.Section;
import qlks.java.qlks_javaweb.service.EmployeeService;
import qlks.java.qlks_javaweb.service.SectionService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SectionService sectionService;

    public EmployeeController(EmployeeService employeeService, SectionService sectionService) {
        this.employeeService = employeeService;
        this.sectionService = sectionService;
    }
    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("listEmployee", employeeService.GetAll());
        return "admin/employees/index";
    }
    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listsection", sectionService.getAll() );
        return "admin/employees/create";
    }
    @PostMapping("/create")
    public String create(@Valid Employee newEmployee,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("employee", newEmployee);
            model.addAttribute("listsection", sectionService.getAll() );
            return "admin/employees/create";
        }
        employeeService.add(newEmployee);
        return "redirect:/admin/employees";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model)
    {
        model.addAttribute("employee", employeeService.get(id));
        model.addAttribute("listsection", sectionService.getAll() );
        return "admin/employees/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid Employee editemployee,
                       BindingResult result,
                       Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("employee", editemployee);
            model.addAttribute("listsection", sectionService.getAll() );
            return "admin/employees/edit";
        }
        employeeService.updateEmployee(editemployee);
        return "redirect:/admin/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployee(id);
        return "redirect:/admin/employees";
    }

}
