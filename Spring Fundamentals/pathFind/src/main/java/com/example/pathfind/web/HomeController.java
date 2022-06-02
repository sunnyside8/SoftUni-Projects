package com.example.pathfind.web;


import com.example.pathfind.model.entity.Route;
import com.example.pathfind.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    @Transactional
    public String home(Model model){
        List<Route> route = routeService.getMostCommented();

        model.addAttribute("mostCommented",route.get(0));
        return "index";
    }

}
