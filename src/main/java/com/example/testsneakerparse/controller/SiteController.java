package com.example.testsneakerparse.controller;

import com.example.testsneakerparse.entity.Paige;
import com.example.testsneakerparse.repository.PaigeRepository;
import com.example.testsneakerparse.service.SiteInterfaceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class SiteController {
    @Autowired
    private final PaigeRepository paigeRepository;

    private String nameWebSite = "https://sneakernews.com";

    @Autowired
    private final SiteRepository siteRepository;
    public SiteController(PaigeRepository paigeRepository, SiteRepository siteRepository) {
        this.paigeRepository = paigeRepository;
        this.siteRepository = siteRepository;
    }
        @GetMapping("/paige/{id}")
    public String watchPaige(@PathVariable Long id , Model model){

        Optional<Paige> paigeList = paigeRepository.findById(id);
        model.addAttribute("paige",paigeList);
        return "paigeId";
        }

        @GetMapping("/")
    public String seeAll(Model model, @RequestParam(value = "size",required = false,defaultValue = "12") Integer size,
                         @RequestParam (value = "page",required = false,defaultValue = "0") Integer page) throws IOException {
//
            model.addAttribute("url","http://localhost:3033");
            model.addAttribute("page",page);
            if (paigeRepository.findAll().size()%2==0){
                Page<Paige> newsPage = (Page<Paige>) paigeRepository.findAll((Pageable) PageRequest.of(page,size).withSort(Sort.by("id").descending()));
                model.addAttribute("news",newsPage);
                model.addAttribute("numbers", IntStream.range(0,newsPage.getTotalPages()).toArray());
                model.addAttribute("newsCurrentPageCount",newsPage.getNumberOfElements());
                model.addAttribute("getNumber",newsPage.getNumber());
            }else {

                Page<Paige> newsPage =  paigeRepository.findAll((Pageable) PageRequest.of(page,size).withSort(Sort.by("id").descending()));
                model.addAttribute("news",newsPage);
                model.addAttribute("numbers", IntStream.range(0,newsPage.getTotalPages()).toArray());
                model.addAttribute("newsCurrentPageCount",newsPage.getNumberOfElements());
                model.addAttribute("getNumber",newsPage.getNumber());
            }
                return "news";
        }
    }