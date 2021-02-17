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

//    @GetMapping(value = "/stackoverflow/{repo}", produces = "application/json")
//    public String stackoverflow(@PathVariable String repo, HttpServletResponse response) {
//        return null;
//    }

    @GetMapping(value = "/twitter/{repo}", produces = "application/json")
    public String twitter(@PathVariable String repo, HttpServletResponse response) {
        TwitterResolver resolver = new TwitterResolver(response, repo);
        return resolver.resolve();
    }
}
