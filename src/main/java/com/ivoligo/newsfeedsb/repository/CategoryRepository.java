package org.ivoligo.newsfeedsb.repository;

import org.ivoligo.newsfeedsb.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
