package com.example.testsneakerparse.controller;

import clojure.lang.Sorted;
import com.example.testsneakerparse.entity.Collect;
import com.example.testsneakerparse.repository.CollectRepository;
import org.hibernate.query.sqm.tree.select.SqmOrderByClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class FormCollectionController {
    @Autowired
   private final CollectRepository collectRepository;
    public FormCollectionController(CollectRepository collectRepository) {
        this.collectRepository = collectRepository;
    }

    @GetMapping("/collection/form")
    public String form(){

        return "form";
    }
    @PostMapping("/collection/form")
    public String formIn(@RequestParam String url1,@RequestParam String url2,
                         @RequestParam String url3,@RequestParam String url4,
                         @RequestParam String url5,@RequestParam String name){

        Collect collect1 = new Collect(url1,url2,url3,url4,url5,name);
        if(url1.isEmpty()||url2.isEmpty()||url3.isEmpty()||url4.isEmpty()||url5.isEmpty()||name.isEmpty()){

        }else {
            collectRepository.save(collect1);

        }


        return "redirect:/collection/all";
    }
    @GetMapping("/collection/all")
    public String customSneakerCollect(Model model){

        List<Collect> collect = collectRepository.findAll(Sort.by("id").descending());
        model.addAttribute("collect",collect);

        return "collectionAll";
    }

    @GetMapping("/collection/{id}")
    public String watchPaige(@PathVariable Long id , Model model){

        Optional<Collect> collect = collectRepository.findById(id);
        model.addAttribute("collectis",collect);
        return "collectionId";
    }
}
