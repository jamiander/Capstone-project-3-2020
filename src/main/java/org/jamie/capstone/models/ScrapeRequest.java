package org.jamie.capstone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScrapeRequest {

    @Id
    @GeneratedValue
    private int id;

    private Websites website;

    public ScrapeRequest(Websites website) {
        this.website = website;
    }

    public ScrapeRequest() {}

    public Websites getWebsite() {
        return website;
    }

    public void setWebsite(Websites website) {
        this.website = website;
    }

    public int getId() {
        return id;
    }

}
