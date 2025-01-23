package com.ivoligo.newsfeedsb.service;

import com.ivoligo.newsfeedsb.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<String> getCategoriesName();
    Category getByName(String categoryName);
}
