package com.gitrends.api.StatsAPI;

public class StatsModel {
    private String site;
    private String owner;
    private String repo;
    private String description;
    private String url;
    private int watchers;
    private int stars;
    private int forks;

    public String getSite() {
        return site;
    }

    public StatsModel setSite(String site) {
        this.site = site;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public StatsModel setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getRepo() {
        return repo;
    }

    public StatsModel setRepo(String repo) {
        this.repo = repo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StatsModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public StatsModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getWatchers() {
        return watchers;
    }

    public StatsModel setWatchers(int watchers) {
        this.watchers = watchers;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public StatsModel setStars(int stars) {
        this.stars = stars;
        return this;
    }

    public int getForks() {
        return forks;
    }

    public StatsModel setForks(int forks) {
        this.forks = forks;
        return this;
    }
}
