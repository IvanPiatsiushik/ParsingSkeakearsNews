package com.example.testsneakerparse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestLazy {

    public TestLazy(){
        System.out.println("LazyUploadingTest");
    }
}
