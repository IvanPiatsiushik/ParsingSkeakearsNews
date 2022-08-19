package com.example.testsneakerparse.service;

import com.example.testsneakerparse.repository.SiteRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

class SiteInterfaceImplTest {
    @Autowired
    private final SiteRepository siteRepository;
    public SiteInterfaceImplTest(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }


    @Test
     void parsingWebPaige() {
       int current = (int) siteRepository.findAll().stream().count();
        assertEquals(current,15);
    }
}