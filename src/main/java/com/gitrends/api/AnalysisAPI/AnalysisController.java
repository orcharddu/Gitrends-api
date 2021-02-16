package com.gitrends.api.AnalysisAPI;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@SpringBootApplication
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @GetMapping(value = "/stackoverflow/{repo}", produces = "application/json")
    public String stackoverflow(@PathVariable String repo, HttpServletResponse response) {
        AnalysisModel<AnalysisModel.Comment> stub = new AnalysisModel<>();
        stub.site = "stackoverflow";
        stub.repo = repo;
        stub.commentList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            AnalysisModel.Comment item = stub.new Comment()
                    .site("stackoverflow").repo(repo).comment("example comment for "+ repo)
                    .positive(0.6).negative(0.314);
            stub.commentList.add(item);
        }
        return new Gson().toJson(stub) ;
    }

    @GetMapping(value = "/twitter/{repo}", produces = "application/json")
    public String twitter(@PathVariable String repo, HttpServletResponse response) {
        AnalysisModel<AnalysisModel.Comment> stub = new AnalysisModel<>();
        stub.site = "twitter";
        stub.repo = repo;
        stub.commentList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            AnalysisModel.Comment item = stub.new Comment()
                    .site("twitter").repo(repo).comment("example comment for "+ repo)
                    .positive(0.6).negative(0.314);
            stub.commentList.add(item);
        }
        return new Gson().toJson(stub) ;
    }
}
