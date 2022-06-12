package com.example.demo.web;


import com.example.demo.model.view.AlbumViewModel;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final AlbumService albumService;
    private final CurrentUser currentUser;

    public HomeController(AlbumService albumService, CurrentUser currentUser) {

        this.albumService = albumService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession,Model model){
       if (currentUser.getId() == null) {
            return "index";
       }

      List<AlbumViewModel> albums = albumService.getAllAlbumsSortedByCopiesDesc();
       int totalCopies = albumService.getTotalCopies();

       model.addAttribute("albums",albums);
       model.addAttribute("totalCopies",totalCopies);
       return "home";


    }
}
