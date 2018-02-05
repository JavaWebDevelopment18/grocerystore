package com.company.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    CosmInventory cosmInventory;

    @Autowired
    CleanInventory cleanInventory;

    @Autowired
    SnackInventory snackInventory;

    @RequestMapping("/")
    public String listAll(Model model){
        model.addAttribute("CleaningItems", cleanInventory.findAll());
        model.addAttribute("Cosmetics", cosmInventory.findAll());
        model.addAttribute("Snacks", snackInventory.findAll());
        model.addAttribute("Total",total());


        return "Main";
    }

    @GetMapping("/cosmform")
    public String newCosmetic(Model model){
        model.addAttribute("cosmetic", new Cosmetic());
        return "CosmForm";
    }

    @PostMapping("/cosmform")
    public String processCosmetic(@Valid @ModelAttribute("cosmetic") Cosmetic cosmetic, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "CosmForm";
        }
        model.addAttribute("cosmetic", cosmetic);
        cosmInventory.save(cosmetic);
        return "redirect:/";

    }

    @GetMapping("/clform")
    public String newCleaning(Model model){
        model.addAttribute("cleaningItem", new CleaningItem());
        return "ClForm";
    }

    @PostMapping("/clform")
    public String processCleaning(@Valid @ModelAttribute("cleaningItem") CleaningItem cleaningItem, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "ClForm";
        }
        model.addAttribute("cleaningItem", cleaningItem);
        cleanInventory.save(cleaningItem);
        return "redirect:/";
    }

    @GetMapping("/sform")
    public String newSnack(Model model){
        model.addAttribute("snack", new Snack());
        return "SForm";
    }

    @PostMapping("/sform")
    public String processSnack(@Valid @ModelAttribute("snack") Snack snack, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "SForm";
        }
        model.addAttribute("snack", snack);
        snackInventory.save(snack);
        return "redirect:/";
    }

    public int total(){
        int total = 0;
        for(Cosmetic cosmetic : cosmInventory.findAll()){
            total += cosmetic.getQuantity() * cosmetic.getPrice();
        }
        for(CleaningItem cleaningItem : cleanInventory.findAll()){
            total += cleaningItem.getQuantity() * cleaningItem.getPrice();
        }
        for(Snack snack : snackInventory.findAll()){
            total += snack.getQuantity() * snack.getPrice();
        }
        return total;

    }


}
