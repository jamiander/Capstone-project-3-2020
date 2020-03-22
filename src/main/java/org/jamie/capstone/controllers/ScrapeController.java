package org.jamie.capstone.controllers;

import org.jamie.capstone.data.ScrapeRepository;
import org.jamie.capstone.models.ScrapeItem;
import org.jamie.capstone.models.ScrapeRequest;
import org.jamie.capstone.models.Websites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("items")
public class ScrapeController {

    @Autowired
    private ScrapeRepository scrapeRepository;

    @GetMapping("scrape")
    public String displayScrapeForm (Model model) {
        model.addAttribute("title", "Choose Website");
        model.addAttribute(new ScrapeRequest());
        return "items/scrape";
    }

    @PostMapping("scrape")
    public String processScrapeForm (@ModelAttribute @Valid ScrapeRequest newScrapeRequest,
                                     Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Choose Website");
            return "items/scrape";
        }





    }


    /*@PostMapping("index")
    public String displayScrapeItems ()
    scrapeRepository.save(newScrapeItem);
        return "redirect:../";*/



}
