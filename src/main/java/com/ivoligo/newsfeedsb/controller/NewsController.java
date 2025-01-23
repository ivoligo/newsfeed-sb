package com.ivoligo.newsfeedsb.controller;

import com.ivoligo.newsfeedsb.model.dto.NewsDto;
import com.ivoligo.newsfeedsb.service.CategoryService;
import com.ivoligo.newsfeedsb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;
    private final CategoryService categoryService;

    public NewsController(@Autowired NewsService newsService, CategoryService categoryService) {
        this.newsService = newsService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showAllNews(Model model) {

        final var newsFeed = newsService.getAll();
        model.addAttribute("newsFeed", newsFeed);
        return "/index";
    }

    @GetMapping("/add")
    public String showAddNews(NewsDto newsDto, Model model) {

        var categories = categoryService.getCategoriesName();
        model.addAttribute("categories", categories);
        return "/add";
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute("news") NewsDto newsDto, @ModelAttribute("categories") List<String> categories,Model model) {

        newsDto.setCategory(categories);
        newsService.create(newsDto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {

        var newsFeed = newsService.getById(id);
        model.addAttribute("news", newsFeed);
        var categories = categoryService.getCategoriesName();
        model.addAttribute("categories", categories);

        return "/edit";
    }


    @PostMapping("/update/{id}")
    public String updateNews(@PathVariable("id") Long id,  @ModelAttribute("categories") List<String> categories, @ModelAttribute("news")  NewsDto newsDto) {

        newsDto.setId(id);
        newsDto.setCategory(categories);
        newsService.update(newsDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") Long id) {

        newsService.delete(id);
        return "redirect:/";
    }
}
