package com.example.testsneakerparse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateCollectionsController {
    @GetMapping("/myCollect")
    public String myCollect(){
        return "/sneakerSlide/sneaker";
    }
}
