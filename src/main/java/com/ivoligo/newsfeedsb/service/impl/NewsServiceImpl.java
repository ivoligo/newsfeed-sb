package org.ivoligo.newsfeedsb.service.impl;

import org.ivoligo.newsfeedsb.model.dto.NewsDto;
import org.ivoligo.newsfeedsb.model.dto.NewsFilter;
import org.ivoligo.newsfeedsb.model.entity.Category;
import org.ivoligo.newsfeedsb.model.entity.News;
import org.ivoligo.newsfeedsb.repository.NewsRepository;
import org.ivoligo.newsfeedsb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(@Autowired NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
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
    public void delete(NewsDto newsDto) {

    }

    @Override
    public void update(NewsDto newsDto) {

    }

    @Override
    public void create(NewsDto newsDto) {

    }

    private NewsDto convert(News news) {
        //todo: использовать builder ?
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setContent(news.getContent());
        newsDto.setCategory(convert(news.getCategories()));
        return newsDto;
    }

    private List<String> convert(List<Category> category) {
        return category.stream().map(Category::getName).collect(Collectors.toList());
    }
}
