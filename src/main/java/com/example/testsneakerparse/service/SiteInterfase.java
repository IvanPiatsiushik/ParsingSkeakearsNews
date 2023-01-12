package com.example.testsneakerparse.service;

import com.example.testsneakerparse.entity.Paige;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface SiteInterfase {
    public String  parsingNamePaige() throws IOException;
    public String  parsingAllPaige() throws IOException;
}
