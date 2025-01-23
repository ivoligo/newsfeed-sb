package org.ivoligo.newsfeedsb.model.dto;

import java.util.List;

public class NewsDto {

    private Long id;
    private String title;
    private String content;
    private String date;
    private List<String> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getCategory() {
        return categories;
    }

    public void setCategory(List<String> category) {
        this.categories = category;
    }
}
