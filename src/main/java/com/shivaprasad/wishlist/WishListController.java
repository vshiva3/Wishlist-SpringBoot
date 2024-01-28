package com.shivaprasad.wishlist;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;



@Controller
public class WishListController {

    ArrayList<WishList> list = new ArrayList<>();
    
    @GetMapping("/")
    public String getHomePage(){
        return "select";
    }

    @GetMapping("/form")
    public String getForm(Model model,@RequestParam(required = false) String id){
        int index = isTheItemAvailable(id);
        model.addAttribute("wishlist", index!=Constants.NOT_FOUND ? list.get(index) : new WishList());
        return "form";
    }

    @PostMapping("/handleList")
    public String receiveData(@Valid @ModelAttribute("wishlist") WishList wishlist, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "form";
        }
        int index = isTheItemAvailable(wishlist.getId());
        String status = Constants.FAIL;
        if(index == Constants.NOT_FOUND){
            list.add(wishlist);
            status = Constants.SUCCESS;
        }
        else {
            list.set(index, wishlist);
            status = Constants.UPDATE;
        }

        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/form";

    }

    @GetMapping("/viewdata")
    public String getViewData(Model model){
        model.addAttribute("items", list);
        return "viewdata";
    }

    public int isTheItemAvailable(String id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

}