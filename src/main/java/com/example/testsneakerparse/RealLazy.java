package com.example.testsneakerparse;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class RealLazy {
    public RealLazy(){
        System.out.println("This real lazy");
    }
}
