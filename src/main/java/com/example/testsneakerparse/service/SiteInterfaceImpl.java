package com.example.testsneakerparse.service;

import com.example.testsneakerparse.entity.Paige;
import com.example.testsneakerparse.entity.Site;
import com.example.testsneakerparse.repository.PaigeRepository;
import com.example.testsneakerparse.repository.SiteRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SiteInterfaceImpl implements SiteInterfase {

    @Autowired
    private final PaigeRepository paigeRepository;

    @Autowired
    private final SiteRepository siteRepository;

    public SiteInterfaceImpl( PaigeRepository paigeRepository, SiteRepository siteRepository) {
        this.paigeRepository = paigeRepository;
        this.siteRepository = siteRepository;
    }

    @Override
    public String parsingNamePaige(String nameWebSite) throws IOException {

        Document document = Jsoup.connect(nameWebSite).get();
        Elements elements = document.select("div.image-box>a");

        for (Element el : elements) {
            List<Site> list1 = siteRepository.findAll();
            boolean compare = list1.stream().anyMatch(x->x.getNamePaige().equals(el.attr("href")));
            if (compare==false){
                Site site1 = new Site(el.attr("href"));
                siteRepository.save(site1);
            }
        }
        return null;
    }

    @Override
    public String parsingAllPaige() throws IOException {

        List<Site> listName = siteRepository.findAll();
        String elementsName = null;
        for (Site el:listName){
            elementsName=el.getNamePaige();

            Document document = Jsoup.connect(elementsName).get();

            Elements elementsMainPicturePaige = document.select("p>img");
            String currentMainPicturePaige = elementsMainPicturePaige.attr("src");

            Elements elementsNameArticle = document.select("h1");
            String currentNameArticle = elementsNameArticle.text();

            Elements elementsFullTextArticle = document.select("div.sneaker-post-content");
            String currentFullTextArticle = elementsFullTextArticle.text();

            Elements elementsPictureAllPaige = document.select("p>img.alignnone");
            List<String> stringsPictureList = elementsPictureAllPaige.stream().map(x->x.attr("src")).collect(Collectors.toList());

            Map<String,String> mapCurrentPicture = new HashMap<>();
            String key = null;

            for (String str:stringsPictureList){

                int indexFinish =1+stringsPictureList.indexOf(str);
                key = "picturePaige"+indexFinish;
                mapCurrentPicture.put(key,str);
            }
            List<Paige> stringList = paigeRepository.findAll();
            Paige paige2 = new Paige(currentNameArticle,currentFullTextArticle,currentMainPicturePaige,
                    mapCurrentPicture.get("picturePaige1"),
                    mapCurrentPicture.get("picturePaige2"),
                    mapCurrentPicture.get("picturePaige3"),
                    mapCurrentPicture.get("picturePaige4"),
                    mapCurrentPicture.get("picturePaige5"),
                    mapCurrentPicture.get("picturePaige6"),
                    mapCurrentPicture.get("picturePaige7"),
                    mapCurrentPicture.get("picturePaige8"),
                    mapCurrentPicture.get("picturePaige9"),
                    mapCurrentPicture.get("picturePaige10"));
            boolean compare = stringList.stream().anyMatch(x->x.getNameArticle().equals(currentNameArticle));
            if (compare==false&&paige2.getPicturePaige1()!=null){
                paigeRepository.save(paige2);
            }
        }
        return null;
    }
    @Override
    public String translateText() {
        return null;
    }
}



