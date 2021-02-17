package com.gitrends.api.AnalysisAPI;

import java.util.List;

public class AnalysisModel<T> {
    private String site;
    private String repo;
    private List<T> commentList;

    public String getSite() {
        return site;
    }

    public AnalysisModel<T> setSite(String site) {
        this.site = site;
        return this;
    }

    public String getRepo() {
        return repo;
    }

    public AnalysisModel<T> setRepo(String repo) {
        this.repo = repo;
        return this;
    }

    public List<T> getCommentList() {
        return commentList;
    }

    public AnalysisModel<T> setCommentList(List<T> commentList) {
        this.commentList = commentList;
        return this;
    }

    public static class Tweet {
        private String site;
        private String repo;
        private String text;
        private String createTime;
        private double positive;
        private double negative;

        public String getSite() {
            return site;
        }

        public Tweet setSite(String site) {
            this.site = site;
            return this;
        }

        public String getRepo() {
            return repo;
        }

        public Tweet setRepo(String repo) {
            this.repo = repo;
            return this;
        }

        public String getText() {
            return text;
        }

        public Tweet setText(String text) {
            this.text = text;
            return this;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Tweet setCreateTime(String createTime) {
            this.createTime = createTime;
            return this;
        }

        public double getPositive() {
            return positive;
        }

        public Tweet setPositive(double positive) {
            this.positive = positive;
            return this;
        }

        public double getNegative() {
            return negative;
        }

        public Tweet setNegative(double negative) {
            this.negative = negative;
            return this;
        }
    }

}
