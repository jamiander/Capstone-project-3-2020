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

    private String rating;

    public ScrapeItem(String title, String rating) {
        this.title = title;
        this.rating = rating;
    }

    public ScrapeItem() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }


}
