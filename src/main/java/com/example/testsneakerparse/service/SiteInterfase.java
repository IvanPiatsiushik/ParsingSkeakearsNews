package com.example.testsneakerparse.service;

import java.io.IOException;

public interface SiteInterfase {
    public String  parsingNamePaige(String nameWebSite) throws IOException;
    public String  parsingAllPaige() throws IOException;
    public  String translateText();
}
