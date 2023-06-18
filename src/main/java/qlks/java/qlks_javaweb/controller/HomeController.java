package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/datphong")
    public String datPhong(Model model,
                           @RequestParam(defaultValue = "0") int pageNo,
                           @RequestParam(defaultValue = "5") int pageSize)
    {
//        Page<room> pages ;
//        boolean checkPrice1 = false;
//        boolean checkPrice2 = false;
//        switch (price) {
//            case 1:
//                pages = roomService.searchChamberWithPrice1();
//                checkPrice1 = true;
//                break;
//            case 2:
//                pages = roomService.searchChamberWithPrice2();
//                checkPrice2 = true;
//                break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + price);
//        }

//        List<room> listCourse = roomService.getbyName();

//        model.addAttribute("room1", checkPrice1);
//        model.addAttribute("room2", checkPrice2);
//        model.addAttribute("room", pages);
//        model.addAttribute("room", roomService.getbyName());

        Page<room> rooms = roomService.list(pageNo, pageSize);
        int totalPages = rooms.getTotalPages();
        model.addAttribute("room", rooms);
        model.addAttribute("totalPages", totalPages);
        return "user/room";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String key,
                                 @RequestParam(defaultValue = "0") int pageNo,
                                 @RequestParam(defaultValue = "5") int pageSize)
    {
        Page<room> rooms = roomService.search(key, pageNo, pageSize);
        int totalPages = rooms.getTotalPages();
        model.addAttribute("room", rooms);
        model.addAttribute("totalPages", totalPages);
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
        model.addAttribute("food", foodItemService.GetAll());
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