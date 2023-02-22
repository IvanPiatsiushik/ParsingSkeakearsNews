package com.example.testsneakerparse.controller;

import clojure.lang.Sorted;
import com.example.testsneakerparse.entity.Collect;
import com.example.testsneakerparse.repository.CollectRepository;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.query.sqm.tree.select.SqmOrderByClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Field;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class FormCollectionController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private final CollectRepository collectRepository;
    public FormCollectionController(CollectRepository collectRepository, EntityManagerFactory entityManagerFactory) {
        this.collectRepository = collectRepository;
        this.entityManagerFactory = entityManagerFactory;
    }

    @GetMapping("/collection/form")
    public String form(){

        return "form";
    }
    public String fieldName(String field){
        String textError = "This field must not be empty!";
        Model model = null;
        model.addAttribute("error_"+field,textError);
        return "";
    }
    @PostMapping("/collection/form")
    public String formIn(@RequestParam String url1,@RequestParam String url2,
                         @RequestParam String url3,@RequestParam String url4,
                         @RequestParam String url5,@RequestParam String name,Model model) throws NoSuchMethodException {

        Collect collect1 = new Collect(url1,url2,url3,url4,url5,name);

        // search private fields from Collect

//        Field[] list = Collect.class.getDeclaredFields();
//        Field [] list1 = Arrays.stream(list).skip(1).collect(Collectors.toList()).toArray(new Field[0]);
//        for (Field nameField : list1 ) System.out.println(nameField.getName());

        String textError = "This field must not be empty.The field must not contain less than 5 elements";
        if (url1.isEmpty()&&url1.length()<5||url2.isEmpty()&&url2.length()<5||url3.isEmpty()&&url3.length()<5||
                url4.isEmpty()&&url4.length()<5||url5.isEmpty()&&url5.length()<5||name.isEmpty()&&name.length()<5){
            model.addAttribute("error",textError);
            return "form";
        }else {
            collectRepository.save(collect1);
        }

        List<Collect> collect = collectRepository.findAll(Sort.by("id").descending());
        model.addAttribute("collect",collect);
        return "collectionAll";
    }
//    @GetMapping("/collection/all")
//    public String customSneakerCollect(Model model){
//
//        List<Collect> collect = collectRepository.findAll(Sort.by("id").descending());
//        model.addAttribute("collect",collect);
//
//        return "collectionAll";
//    }
    @GetMapping("/list")
    public String list(Model model){
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
