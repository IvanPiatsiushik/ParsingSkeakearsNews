package com.example.testsneakerparse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Site {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    private String namePaige;

    public Site() {
    }

    public Site(String namePaige) {
        this.namePaige = namePaige;
    }

    public String getNamePaige() {
        return namePaige;
    }

    public void setNamePaige(String namePaige) {
        this.namePaige = namePaige;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", namePaige='" + namePaige + '\'' +
                '}';
    }
}
