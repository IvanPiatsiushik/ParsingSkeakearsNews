package com.example.testsneakerparse.controller;

import com.example.testsneakerparse.TestBean;
import com.example.testsneakerparse.entity.Paige;
import com.example.testsneakerparse.repository.PaigeRepository;
import com.example.testsneakerparse.service.SiteInterfase;
import com.example.testsneakerparse.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
public class SiteController {

    @Autowired
    private TestBean testBean;
    @Autowired
    private final  SiteInterfase siteInterfase;
    @Autowired
    private final PaigeRepository paigeRepository;
    @Value("${pagination.path}")
    private String paginationPath;

    @Value("${pagination.path.filter}")
    private String paginationPathFilter;
    @Autowired
    private final SiteRepository siteRepository;
    public SiteController(SiteInterfase siteInterfase, PaigeRepository paigeRepository, SiteRepository siteRepository) {
        this.siteInterfase = siteInterfase;
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


        testBean.method();

            model.addAttribute("url",paginationPath);
            model.addAttribute("page",page);

            Long quantity = paigeRepository.findAll().stream().count();

            Page<Paige> newsPage = (Page<Paige>) paigeRepository.findAll((Pageable) PageRequest.of(page,size).withSort(Sort.by("id").descending()));

                model.addAttribute("news",newsPage);
                model.addAttribute("newsGet",newsPage.getTotalPages());
                model.addAttribute("numbers", IntStream.range(0,newsPage.getTotalPages()).toArray());
                model.addAttribute("newsCurrentPageCount",newsPage.getNumberOfElements());
                model.addAttribute("getNumber",newsPage.getNumber());
                model.addAttribute("quantity",quantity);
                return "/test/test";
        }
        @PostMapping("/search")
    public String filter(@Param("search") String search, Model model, @RequestParam(value = "size",required = false,defaultValue = "12") Integer size,
                         @RequestParam (value = "page",required = false,defaultValue = "0") Integer page) throws IOException{


            Page<Paige> newsPageSearch;
            if(search==null && search.isEmpty()){
//            newsPage = (Page<Paige>) paigeRepository.findAll((Pageable) PageRequest.of(page,size).withSort(Sort.by("id").descending()));
                return "improveNews";
        }
        else {

            newsPageSearch = (Page<Paige>) paigeRepository.findPaigeByNameArticle(search,(Pageable) PageRequest.of(page,size).withSort(Sort.by("id").descending()));

        }

            model.addAttribute("urls",paginationPathFilter);
            model.addAttribute("page",page);
            model.addAttribute("filter",search);

            Long quantity = paigeRepository.findAll().stream().count();

            model.addAttribute("news1",newsPageSearch);
            model.addAttribute("newsGet",newsPageSearch.getTotalPages());
            model.addAttribute("numbers", IntStream.range(0,newsPageSearch.getTotalPages()).toArray());
            model.addAttribute("newsCurrentPageCount",newsPageSearch.getNumberOfElements());
            model.addAttribute("getNumber1",newsPageSearch.getNumber());
            model.addAttribute("quantity",quantity);
            return "searchNews";
        }
    }