package com.ivoligo.newsfeedsb.service;

import com.ivoligo.newsfeedsb.model.dto.NewsDto;
import com.ivoligo.newsfeedsb.model.dto.NewsFilter;

import java.util.List;

public interface NewsService {

    List<NewsDto> getAll();

    void create(NewsDto newsDto);

    void update(NewsDto newsDto);

    List<NewsDto> find(NewsFilter filter);

    void delete(Long id);

    NewsDto getById(Long id);
}
