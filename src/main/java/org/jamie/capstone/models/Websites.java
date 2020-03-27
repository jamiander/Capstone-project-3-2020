package org.jamie.capstone.models;

public enum Websites {

    IMDB("https://www.imdb.com/chart/top/"),
    DALI_APPRECIATION_SUBREDDIT("https://www.reddit.com/r/SalvadorDali/");


    private String website;

    Websites(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

}
