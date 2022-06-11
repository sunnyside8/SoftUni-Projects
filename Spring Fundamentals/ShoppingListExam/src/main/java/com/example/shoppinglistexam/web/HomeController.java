package com.example.shoppinglistexam.web;

import com.example.shoppinglistexam.model.entity.CategoryEnum;
import com.example.shoppinglistexam.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession,Model model){
       if (httpSession.getAttribute("user") == null) {
            return "index";
       }
        model.addAttribute("totalSum",productService.getTotalSum());
        model.addAttribute("drinks",productService.findAllProductsByCategory(CategoryEnum.Drink));
        model.addAttribute("food",productService.findAllProductsByCategory(CategoryEnum.Food));
        model.addAttribute("household",productService.findAllProductsByCategory(CategoryEnum.Household));
        model.addAttribute("other",productService.findAllProductsByCategory(CategoryEnum.Other));
       return "home";
    }
}
