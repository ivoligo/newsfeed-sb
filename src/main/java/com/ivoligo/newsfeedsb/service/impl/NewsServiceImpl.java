package com.ivoligo.newsfeedsb.service.impl;

import com.ivoligo.newsfeedsb.model.dto.NewsDto;
import com.ivoligo.newsfeedsb.model.dto.NewsFilter;
import com.ivoligo.newsfeedsb.model.entity.Category;
import com.ivoligo.newsfeedsb.model.entity.News;
import com.ivoligo.newsfeedsb.repository.NewsRepository;
import com.ivoligo.newsfeedsb.service.CategoryService;
import com.ivoligo.newsfeedsb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final CategoryService categoryService;

    public NewsServiceImpl(@Autowired NewsRepository newsRepository, CategoryService categoryService) {
        this.newsRepository = newsRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<NewsDto> getAll() {

        var newsList = newsRepository.findAll();
        return newsList.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public List<NewsDto> find(NewsFilter filter) {

//        newsRepository.findAll(filter.getTitle())
        return List.of();
    }

    @Override
    public void delete(Long id) {

        var news = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с id: " + id + " не найден "));
        newsRepository.delete(news);
    }

    @Override
    public NewsDto getById(Long id) {

        var news = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с id: " + id + " не найден "));

        var test = convert(news);
        return test;
    }

    @Override
    public void update(NewsDto newsDto) {

    }

    @Override
    public void create(NewsDto newsDto) {
        var news = new News();
        news.setTittle(newsDto.getTittle());
        news.setContent(newsDto.getContent());
        news.setDate(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        var categories = new ArrayList<Category>();
        for (String categoryName:newsDto.getCategory()) {
            var category = categoryService.getByName(categoryName);
            categories.add(category);
        }
        news.setCategories(categories);
        newsRepository.save(news);

    }

    private NewsDto convert(News news) {
        //todo: использовать builder ?
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTittle(news.getTittle());
        newsDto.setContent(news.getContent());
        newsDto.setDate(news.getDate().toString());
        newsDto.setCategory(convert(news.getCategories()));
        return newsDto;
    }

    private List<String> convert(List<Category> category) {
        return category.stream().map(Category::getName).collect(Collectors.toList());
    }
}
