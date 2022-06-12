package com.example.demo.web;

import com.example.demo.model.binding.AlbumBindingModel;
import com.example.demo.model.service.AlbumServiceModel;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("albums")
public class AlbumController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(CurrentUser currentUser, AlbumService albumService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        if(currentUser.getId() == null){
            return "redirect:/login";
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumBindingModel albumBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("albumBindingModel",albumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel",bindingResult);

            return "redirect:add";
        }

        albumService.add(modelMapper.map(albumBindingModel, AlbumServiceModel.class));

        return "redirect:/";

    }

    @ModelAttribute
    public AlbumBindingModel albumBindingModel(){
        return new AlbumBindingModel();
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id){
        albumService.buyById(id);

        return "redirect:/";
    }
}
