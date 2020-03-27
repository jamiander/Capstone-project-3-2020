package org.jamie.capstone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ScrapeItem {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String content;

    public ScrapeItem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ScrapeItem() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setRating(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }


}
