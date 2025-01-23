package com.ivoligo.newsfeedsb.repository;


import com.ivoligo.newsfeedsb.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
