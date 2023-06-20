package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import qlks.java.qlks_javaweb.model.Rental;
import qlks.java.qlks_javaweb.model.User;
import qlks.java.qlks_javaweb.service.RentalService;

import java.util.Optional;

@Controller
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @GetMapping("/admin/rental")
    public String showRental(Model model){
        model.addAttribute("listRental",rentalService.GetAll());
        return "admin/rental/index";
    }

    @GetMapping("/admin/rental/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        this.rentalService.remove(id);
        return "redirect:/admin/rental";
    }
    @GetMapping("/rentals/{rentalId}")
    public String getRentalDetails(@PathVariable("rentalId") Long rentalId, Model model) {
        Rental rental = rentalService.getRentalById(rentalId);
        model.addAttribute("rental", rental);
        return "admin/rental/details";
    }

}
