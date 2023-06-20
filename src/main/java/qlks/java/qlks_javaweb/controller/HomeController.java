package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.service.FoodItemService;
import qlks.java.qlks_javaweb.service.RoomService;
import qlks.java.qlks_javaweb.service.ServiceService;

import java.util.List;


@Controller
@RequestMapping("user")
public class HomeController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/")
    public String index(){
        return "user/home";
    }

    @GetMapping("/room")
    public String datPhong(Model model)
    {
        List<room> rooms = roomService.list();
        model.addAttribute("room", rooms);
        return "user/room";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String key)
    {
        List<room> rooms = roomService.search(key);
        model.addAttribute("room", rooms);
        return "user/room";
    }

    @GetMapping("/service")
    public String list(Model model)
    {
        model.addAttribute("services", serviceService.GetAll());
        return "user/service";
    }
    @GetMapping("/food")
    public String listfood(Model model)
    {
//        model.addAttribute("food", foodItemService.GetAll());
//        return "user/food_items";
        return findPaginated(1, "foodId", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 4;

        Page<food_item> page = foodItemService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<food_item> listfood = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("food", listfood);
        return "user/food_items";
    }





    @GetMapping("/encode/{pass}")
    @ResponseBody
    public String encode(@PathVariable String pass)
    {
        return new BCryptPasswordEncoder().encode(pass);
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }
}