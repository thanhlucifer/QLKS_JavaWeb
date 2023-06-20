package qlks.java.qlks_javaweb.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.service.RoomService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/admin/room")
    public String viewHomePage(Model model) {
        return findPaginated(1 ,model);
    }

    @GetMapping("/admin/room/create")
    public String create(Model model) {
        // create model attribute to bind form data
        room room = new room();
        model.addAttribute("room", room);
        return "admin/room/create";
    }

    @GetMapping("/admin/room/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        this.roomService.remove(id);
        return "redirect:/admin/room";
    }
    @PostMapping("/admin/room/save")
    public String saveEmployee(@Valid room room,
                               @RequestParam MultipartFile imageProduct,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("room", room);
            return "admin/room/create";
        }
        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images/room").getFile();
                String newImageFile = UUID.randomUUID() +  ".jpg";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                room.setImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // save employee to database
        roomService.save(room);
        return "redirect:/admin/room";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,

                                Model model) {
        int pageSize = 4;

        Page<room> page = roomService.findPaginated(pageNo, pageSize);
        List<room> listRoom = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listRoom", listRoom);
        return "admin/room/index";
    }


}
