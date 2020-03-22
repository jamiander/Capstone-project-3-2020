package org.jamie.capstone.models;

public enum Websites {

    IMDB("https://www.imdb.com/chart/top/");

    private String website;

    Websites(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

}
