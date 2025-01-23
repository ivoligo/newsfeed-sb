package com.ivoligo.newsfeedsb.repository;

import com.ivoligo.newsfeedsb.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.name = (:name)")
    Category findByName(@Param("name")String name);
}
