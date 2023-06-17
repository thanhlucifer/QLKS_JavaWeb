package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qlks.java.qlks_javaweb.service.FoodItemService;

@Controller
@RequestMapping("/user/food_items")
public class UserFoodController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("")
    public String list(Model model)
    {
        model.addAttribute("food", foodItemService.GetAll());
        return "user/food_items";
    }
}
