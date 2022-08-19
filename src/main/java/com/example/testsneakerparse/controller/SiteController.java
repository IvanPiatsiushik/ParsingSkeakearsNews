package com.example.testsneakerparse.controller;

import com.example.testsneakerparse.entity.Paige;
import com.example.testsneakerparse.repository.PaigeRepository;
import com.example.testsneakerparse.service.SiteInterfase;
import com.example.testsneakerparse.entity.Site;
import com.example.testsneakerparse.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SiteController {
    @Autowired
    private final PaigeRepository paigeRepository;

    private String nameWebSite = "https://sneakernews.com";

    @Autowired
    private final SiteInterfase siteInterfase;
    @Autowired
    private final SiteRepository siteRepository;
    public SiteController(PaigeRepository paigeRepository, SiteInterfase siteInterfase, SiteRepository siteRepository) {
        this.paigeRepository = paigeRepository;
        this.siteInterfase = siteInterfase;
        this.siteRepository = siteRepository;
    }

    @GetMapping("/site")
    public String findAllPaige(Model model) throws IOException {

            List<Site> list = siteRepository.findAll();
            model.addAttribute("allPaige", list);
            siteInterfase.parsingNamePaige(nameWebSite);
            siteInterfase.parsingAllPaige();
        return "site";
        }

        @GetMapping("/paige/{id}")
    public String watchPaige(@PathVariable Long id , Model model){

        Optional<Paige> paigeList = paigeRepository.findById(id);
        model.addAttribute("paige",paigeList);
        return "paigeId";
        }

        @GetMapping("/ppp")
    public String seeAll(Model model){

            if (paigeRepository.findAll().size()%2==0){
                List<Paige> paigeList1 = (List<Paige>) paigeRepository.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Paige::getId).reversed())
                        .collect(Collectors.toList());
                model.addAttribute("paiges",paigeList1);
            }else {
                List<Paige> paigeList1 = (List<Paige>) paigeRepository.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Paige::getId).reversed())
                        .skip(1)
                        .collect(Collectors.toList());
                model.addAttribute("paiges",paigeList1);

            }
                return "news";
        }
    }