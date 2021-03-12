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
        /*
        return "{\n" +
                "    \"site\": \"twitter\",\n" +
                "    \"repo\": \"ant-design\",\n" +
                "    \"commentList\": [\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"@WRIClimate Why,\u200B always a similar design \uD83E\uDD14 \uD83D\uDE44. Look and learn #energy  https://t.co/dnDChpy0x1 https://t.co/eyHNt93TIO\",\n" +
                "            \"createTime\": \"2021-02-17T08:56:03.000Z\",\n" +
                "            \"positive\": 0.8268767691027397,\n" +
                "            \"negative\": 0.17312323089726034\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"@AntDesignUI I am happy that this issue has been resolved.\\nI appreciate the https://t.co/Lky6oGmVKo UI and would like to continue using it.\\nBut why did this problem occur? I want you to explain.\",\n" +
                "            \"createTime\": \"2021-02-17T07:30:56.000Z\",\n" +
                "            \"positive\": 0.4995858185444263,\n" +
                "            \"negative\": 0.5004141814555737\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"Ant design, the best ui library for react has been hacked and the whole repo was deleted from #github. If you want to help, give them a star. It used to have almost 70k stars but now only 861. \uD83D\uDE14 \\n\\nhttps://t.co/kXJkb8vBBG\\n\\n@AntDesignUI #antd #antdesign #designsystem\",\n" +
                "            \"createTime\": \"2021-02-17T06:14:51.000Z\",\n" +
                "            \"positive\": 0.2002104464426162,\n" +
                "            \"negative\": 0.7997895535573838\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"@youyuxi I gave up when I couldn't achieve vuex dynamic module load in a short time. Also at that time, ant-design-vue was not fully supported for vitejs.\",\n" +
                "            \"createTime\": \"2021-02-17T05:44:35.000Z\",\n" +
                "            \"positive\": 0.8593473110133135,\n" +
                "            \"negative\": 0.14065268898668648\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"But a shockingly top notch component-based Chinese dashboard went to my rescue https://t.co/664RI9Q9vG\\n\\n\uD83D\uDC4F incredible job\",\n" +
                "            \"createTime\": \"2021-02-17T02:54:50.000Z\",\n" +
                "            \"positive\": 0.9814139877922633,\n" +
                "            \"negative\": 0.018586012207736702\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"Am I missing something? Seems odd that Ant/Material would be so heavy a lift but I'm not seeing a speed benefit when building what should be quick experiments. Choosing a system for the next project, have lots of quick options for eng, but little design tool support for me.\",\n" +
                "            \"createTime\": \"2021-02-17T02:51:20.000Z\",\n" +
                "            \"positive\": 0.2017030857307205,\n" +
                "            \"negative\": 0.7982969142692795\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"Does anyone here use https://t.co/j3T00YQkAc as your UI framework?\",\n" +
                "            \"createTime\": \"2021-02-16T23:27:21.000Z\",\n" +
                "            \"positive\": 0.5211420372669784,\n" +
                "            \"negative\": 0.4788579627330216\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"@mavericksmovies Oooooh I remember seeing Antz. The ant's design used to freak me out. They didn't look as friendly as the ants from Bug's life. Which, happened to be relesead the same year if I'm not mistaken\",\n" +
                "            \"createTime\": \"2021-02-16T21:54:15.000Z\",\n" +
                "            \"positive\": 0.760846501476,\n" +
                "            \"negative\": 0.23915349852400003\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"What's your favorite React UI library?\\n\\nI can no longer lean on Ant Design.\",\n" +
                "            \"createTime\": \"2021-02-16T19:48:37.000Z\",\n" +
                "            \"positive\": 0.615741912119928,\n" +
                "            \"negative\": 0.384258087880072\n" +
                "        },\n" +
                "        {\n" +
                "            \"site\": \"twitter\",\n" +
                "            \"repo\": \"ant-design\",\n" +
                "            \"text\": \"Looks like the main @AntDesignUI repo at  https://t.co/UFnGPW8Hny exists again, but is it under the correct ownership? What happened here? Don't see any mentions in @github issues or discussions.\\n\\nWould appreciate a postmortem to allay security concerns.\\n\\nhttps://t.co/ihizqLQeXI\",\n" +
                "            \"createTime\": \"2021-02-16T18:45:56.000Z\",\n" +
                "            \"positive\": 0.13285777504496643,\n" +
                "            \"negative\": 0.8671422249550336\n" +
                "        }\n" +
                "    ]\n" +
                "}";

         */
    }
}
