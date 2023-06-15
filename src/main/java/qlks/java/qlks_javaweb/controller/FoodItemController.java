package qlks.java.qlks_javaweb.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qlks.java.qlks_javaweb.MultipartFileToStringConverter;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.service.FoodItemService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/admin/food_items")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("")
    public String list(Model model)
    {
        model.addAttribute("listfood", foodItemService.GetAll());
        return "admin/food_items/list";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("food", new food_item());
        return "admin/food_items/create";
    }
    @PostMapping("/create")
    public String create(@Valid food_item newfooditem,
                         @RequestParam MultipartFile imageProduct,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("food", newfooditem);
            return "admin/food_items/create";
        }
        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images_food").getFile();
                String newImageFile = UUID.randomUUID() +  ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newfooditem.setFoodImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        foodItemService.add(newfooditem);
        return "redirect:/admin/food_items";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model)
    {
        model.addAttribute("food", foodItemService.get(id));
        return "admin/food_items/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid food_item editfooditem,
                       @RequestParam MultipartFile imageProduct,
                       BindingResult result,
                       Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("food", editfooditem);
            return "admin/food_items/edit";
        }
        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images_food").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + editfooditem.getFoodImage());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        foodItemService.edit(editfooditem);
        return "redirect:/admin/food_items";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.foodItemService.remove(id);
        return "redirect:/admin/food_items";
    }
}
