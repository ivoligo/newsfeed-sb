package org.ivoligo.newsfeedsb.controller;

import org.ivoligo.newsfeedsb.model.dto.NewsDto;
import org.ivoligo.newsfeedsb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(@Autowired NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String showAllNews(Model model) {

        final var newsFeed = newsService.getAll();
        model.addAttribute("newsFeed", newsFeed);
        return "/index";
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute("news") NewsDto newsDto) {

        newsService.create(newsDto);
        return "redirect:/";
    }
}
