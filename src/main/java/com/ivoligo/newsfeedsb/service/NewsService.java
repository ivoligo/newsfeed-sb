package org.ivoligo.newsfeedsb.service;

import org.ivoligo.newsfeedsb.model.dto.NewsDto;
import org.ivoligo.newsfeedsb.model.dto.NewsFilter;

import java.util.List;

public interface NewsService {

    List<NewsDto> getAll();

    void create(NewsDto newsDto);

    void update(NewsDto newsDto);

    List<NewsDto> find(NewsFilter filter);

    void delete(NewsDto newsDto);
}
