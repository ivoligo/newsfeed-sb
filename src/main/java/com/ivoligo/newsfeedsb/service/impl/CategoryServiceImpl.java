package com.ivoligo.newsfeedsb.service.impl;

import com.ivoligo.newsfeedsb.model.dto.CategoryDto;
import com.ivoligo.newsfeedsb.model.entity.Category;
import com.ivoligo.newsfeedsb.repository.CategoryRepository;
import com.ivoligo.newsfeedsb.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<String> getCategoriesName() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    @Override
    public Category getByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

}
