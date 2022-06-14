package com.example.demo.web;


import com.example.demo.model.binding.BattleBindingModel;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.ShipService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        model.addAttribute("currentUserShips", shipService.getShipsOrdered(currentUser.getId()));
        model.addAttribute("otherUserShips", shipService.getShipsOrdered(2L));
        model.addAttribute("allShips",shipService.getAll());

        return "home";
    }

    @PostMapping("/home/battle")
    public String postBattle(@Valid BattleBindingModel battleBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("error",battleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleBindingModel",bindingResult);

            return "redirect:/";
        }

        shipService.attack(battleBindingModel.getAttacker(),battleBindingModel.getDefender());

        return "redirect:/";
    }

    @ModelAttribute
    public BattleBindingModel battleBindingModel(){
        return new BattleBindingModel();
    }


}
