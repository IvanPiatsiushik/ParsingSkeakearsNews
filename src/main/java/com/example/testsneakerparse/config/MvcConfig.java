package com.example.testsneakerparse.config;

import com.example.testsneakerparse.entity.Site;
import com.example.testsneakerparse.service.SiteInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private SiteInterfase siteInterfase;
    @Bean
    public Site parsingWebSite() {

        String nameWebSite = "https://sneakernews.com";
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                try {
                    siteInterfase.parsingNamePaige(nameWebSite);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(task,3000,30000000);
        return null;
    }
    @Bean
    public Page parsingAllInfarmation() throws IOException {
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    siteInterfase.parsingAllPaige();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//        timer.schedule(task,3000,30000000);

                        siteInterfase.parsingAllPaige();

        return null;
    }
}
