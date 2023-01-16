package com.example.testsneakerparse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class RestApiTest {
    public List<Map<String,String>> messages = new ArrayList<>(){{
        add(new HashMap<>(){{put("id","1");put("text","First massage");}});
        add(new HashMap<>(){{put("id","2");put("text","Second massage");}});
        add(new HashMap<>(){{put("id","3");put("text","Third massage");}});
        add(new HashMap<>(){{put("id","4");put("text","Fo massage");}});
    }};

    @GetMapping
    public List<Map<String,String>> list(){
        return messages;
    }
    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
     return messages.stream().filter(x->x.get("id").equals(id))
             .findFirst()
             .orElseThrow();
    }
}