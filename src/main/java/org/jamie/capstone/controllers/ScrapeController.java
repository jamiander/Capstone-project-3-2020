package org.jamie.capstone.controllers;

import org.jamie.capstone.data.ScrapeRequestRepository;
import org.jamie.capstone.models.Websites;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jamie.capstone.data.ScrapeRepository;
import org.jamie.capstone.data.ScrapeRequestRepository;
import org.jamie.capstone.models.ScrapeItem;
import org.jamie.capstone.models.ScrapeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("items")
public class ScrapeController {

    @Autowired
    private ScrapeRepository scrapeRepository;

    @Autowired
    private ScrapeRequestRepository scrapeRequestRepository;

    @GetMapping("scrape")
    public String displayScrapeForm(Model model) {
        model.addAttribute("title", "Choose Website");
        model.addAttribute(new ScrapeRequest());
        model.addAttribute("websites", Websites.values());
        return "items/scrape";
    }

    @PostMapping("scrape")
    public String processScrapeForm(@ModelAttribute @Valid ScrapeRequest newScrapeRequest, ScrapeItem newScrapeItem,
                                    Errors errors, Model model) throws IOException {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Choose Website");
            model.addAttribute("scrapeRequest", newScrapeRequest);
            return "items/scrape";
        }

        scrapeRequestRepository.save(newScrapeRequest);

        String url = newScrapeRequest.getWebsite().getWebsite();
        Document page = Jsoup.connect(url).get();

        if (url.contains("imdb")) {
            for (Element row : page.select("table.chart.full-width tr")) {
                final String title = row.select(".titleColumn a").text();
                final String content = row.select(".ratingColumn.imdbRating").text();
                model.addAttribute("scrapeItem", newScrapeItem = new ScrapeItem(title, content));
                scrapeRepository.save(newScrapeItem);
            }
        } else if (url.contains("reddit")) {
            for (Element row : page.select("ul.rows.result-info")) {
                final String title = row.select(".result-title.hdrlnk").text();
                final String content = row.select(".result-meta.result-price").text();
                model.addAttribute("scrapeItem", newScrapeItem = new ScrapeItem(title, content));
                scrapeRepository.save(newScrapeItem);
            }
        }
        return "redirect:../";
    }
}






