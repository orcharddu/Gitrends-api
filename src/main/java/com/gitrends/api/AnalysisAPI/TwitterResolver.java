package com.gitrends.api.AnalysisAPI;

import com.gitrends.api.Utils.Connector;
import com.gitrends.api.Utils.Token;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwitterResolver {
    private String repo;
    private HttpServletResponse httpResponse;

    public TwitterResolver(HttpServletResponse response, String repo) {
        this.httpResponse = response;
        this.repo = repo;
    }

    private JsonObject getRelatedTweets(String repo) throws Exception{
        String repoAlt = repo.replace('-', ' ');
        String url = "https://api.twitter.com/2/tweets/search/recent?query="
                + "(" + repo + " OR %23" + repo;
        if(!repoAlt.equals(repo)) {
            url += " OR " + repoAlt;
        }
        url +=  ") "
                + "lang:en "
                + "-is:retweet"
                + "&tweet.fields=created_at,possibly_sensitive";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", Token.TOKEN_TWITTER);
        return Connector.getJsonResponse(url, headers);
    }

    private String processTweets(JsonObject json) {
        JsonArray jsonElements = json.getAsJsonArray("data");
        AnalysisModel<AnalysisModel.Tweet> analysis = new AnalysisModel<>();
        analysis.setSite("twitter");
        analysis.setRepo(repo);
        analysis.setCommentList(new ArrayList<>());
        for(JsonElement jsonElement : jsonElements) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if(jsonObject.get("possibly_sensitive").getAsBoolean()) {
                continue;
            }
            AnalysisModel.Tweet tweet = new AnalysisModel.Tweet();
            double positive = Math.random();
            double negative = 1 - positive;
            tweet.setSite("twitter")
                    .setRepo(repo)
                    .setText(jsonObject.get("text").getAsString())
                    .setCreateTime(jsonObject.get("created_at").getAsString())
                    .setPositive(positive)
                    .setNegative(negative);
            analysis.getCommentList().add(tweet);
        }
        return new Gson().toJson(analysis);
    }

    public String resolve() {
        String response;
        httpResponse.setStatus(200);
        try {
            JsonObject tweets = getRelatedTweets(repo);
            response = processTweets(tweets);
        } catch(Exception e) {
            response = "api.gitrends.com: " + e.toString();
            httpResponse.setStatus(500);
        }
        return response;
    }

}
