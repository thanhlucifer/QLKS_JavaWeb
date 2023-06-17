package qlks.java.qlks_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.service.RoomService;
import qlks.java.qlks_javaweb.service.ServiceService;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public String index(){
        return "user/home";
    }
    @GetMapping("/datphong")
    public String datPhong(Model model, String keyword ) {
        List<room> listCourse = roomService.getbyName();
        model.addAttribute("room", roomService.getbyName());
        return "user/room";
    }

    @GetMapping("/service")
    public String list(Model model)
    {
        model.addAttribute("services", serviceService.GetAll());
        return "user/service";
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