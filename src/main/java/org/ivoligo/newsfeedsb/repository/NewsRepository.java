package org.ivoligo.newsfeedsb.repository;


import org.ivoligo.newsfeedsb.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

}
