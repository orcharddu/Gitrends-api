package com.gitrends.api.AnalysisAPI;

import java.util.List;

public class AnalysisModel<T> {
    String site;
    String repo;
    List<T> commentList;

    public class Comment {
        String site;
        String repo;
        String comment;
        double positive;
        double negative;
        Comment site(String site) { this.site = site; return this; }
        Comment repo(String repo) { this.repo = repo; return this; }
        Comment comment(String comment) { this.comment = comment; return this; }
        Comment positive(double positive) { this.positive = positive; return this; }
        Comment negative(double negative) { this.negative = negative; return this; }
    }

}
