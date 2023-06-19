package qlks.java.qlks_javaweb.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qlks.java.qlks_javaweb.model.Rental;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.service.BookRoomService;
import qlks.java.qlks_javaweb.service.RoomService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("user/bookroom")
public class BookRoomController {

    @Autowired
    public BookRoomService bookRoomService;
    @Autowired
    public RoomService roomService;

    @GetMapping("{id}")
    public String bookRoom(@PathVariable long id, Model model) {
        model.addAttribute("room", roomService.getById(id));
        model.addAttribute("rental", new Rental());
        return "user/bookroom";
    }

    @PostMapping("")
    public String bookRoom(@Valid Rental newRental,@Valid room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("room",room);
            model.addAttribute("rental", newRental );
            return "user/bookroom";
        }
        bookRoomService.add(newRental);
        return "user/confirm_bookroom";
    }
}
