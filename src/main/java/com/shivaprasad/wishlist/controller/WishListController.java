package com.shivaprasad.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shivaprasad.wishlist.pojo.WishList;
import com.shivaprasad.wishlist.service.WishlistService;

import jakarta.validation.Valid;



@Controller
public class WishListController {

    @Autowired
    WishlistService wishlistService;
    
    @GetMapping("/")
    public String getHomePage(){
        return "select";
    }

    @GetMapping("/form")
    public String getForm(Model model,@RequestParam(required = false) String id){
        
        model.addAttribute("wishlist", wishlistService.putItemInModel(id));
        return "form";
    }

    @PostMapping("/handleList")
    public String receiveData(@Valid @ModelAttribute WishList wishlist, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "form";
        }
        
        String status = wishlistService.addToRepo(wishlist);

        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/form";

    }

    @GetMapping("/viewdata")
    public String getViewData(Model model){
        model.addAttribute("items", wishlistService.getTotalList());
        return "viewdata";
    }


}