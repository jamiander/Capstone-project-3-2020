package org.jamie.capstone.models;

public enum Websites {

    IMDB("https://www.imdb.com/chart/top/"),
    ROTTEN_TOMATOES("https://www.rottentomatoes.com/top/");


    private String website;

    Websites(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

}
