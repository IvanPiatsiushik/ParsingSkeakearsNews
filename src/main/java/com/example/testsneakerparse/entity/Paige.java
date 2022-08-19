package com.example.testsneakerparse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paige {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    private String nameArticle;
    private String fullTextArticle;
    private String mainPicturePaige;


    private String picturePaige1;
    private String picturePaige2;
    private String picturePaige3;
    private String picturePaige4;
    private String picturePaige5;
    private String picturePaige6;
    private String picturePaige7;
    private String picturePaige8;
    private String picturePaige9;
    private String picturePaige10;
    public Paige() {
    }

    public Paige(String nameArticle, String fullTextArticle, String mainPicturePaige) {
        this.nameArticle = nameArticle;
        this.fullTextArticle = fullTextArticle;
        this.mainPicturePaige = mainPicturePaige;
    }

    public Paige(String nameArticle, String fullTextArticle, String mainPicturePaige, String picturePaige1, String picturePaige2, String picturePaige3, String picturePaige4, String picturePaige5, String picturePaige6, String picturePaige7, String picturePaige8, String picturePaige9, String picturePaige10) {
        this.nameArticle = nameArticle;
        this.fullTextArticle = fullTextArticle;
        this.mainPicturePaige = mainPicturePaige;
        this.picturePaige1 = picturePaige1;
        this.picturePaige2 = picturePaige2;
        this.picturePaige3 = picturePaige3;
        this.picturePaige4 = picturePaige4;
        this.picturePaige5 = picturePaige5;
        this.picturePaige6 = picturePaige6;
        this.picturePaige7 = picturePaige7;
        this.picturePaige8 = picturePaige8;
        this.picturePaige9 = picturePaige9;
        this.picturePaige10 = picturePaige10;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getFullTextArticle() {
        return fullTextArticle;
    }

    public void setFullTextArticle(String fullTextArticle) {
        this.fullTextArticle = fullTextArticle;
    }

    public String getMainPicturePaige() {
        return mainPicturePaige;
    }

    public void setMainPicturePaige(String mainPicturePaige) {
        this.mainPicturePaige = mainPicturePaige;
    }

    public String getPicturePaige1() {
        return picturePaige1;
    }

    public void setPicturePaige1(String picturePaige1) {
        this.picturePaige1 = picturePaige1;
    }

    public String getPicturePaige2() {
        return picturePaige2;
    }

    public void setPicturePaige2(String picturePaige2) {
        this.picturePaige2 = picturePaige2;
    }

    public String getPicturePaige3() {
        return picturePaige3;
    }

    public void setPicturePaige3(String picturePaige3) {
        this.picturePaige3 = picturePaige3;
    }

    public String getPicturePaige4() {
        return picturePaige4;
    }

    public void setPicturePaige4(String picturePaige4) {
        this.picturePaige4 = picturePaige4;
    }

    public String getPicturePaige5() {
        return picturePaige5;
    }

    public void setPicturePaige5(String picturePaige5) {
        this.picturePaige5 = picturePaige5;
    }

    public String getPicturePaige6() {
        return picturePaige6;
    }

    public void setPicturePaige6(String picturePaige6) {
        this.picturePaige6 = picturePaige6;
    }

    public String getPicturePaige7() {
        return picturePaige7;
    }

    public void setPicturePaige7(String picturePaige7) {
        this.picturePaige7 = picturePaige7;
    }

    public String getPicturePaige8() {
        return picturePaige8;
    }

    public void setPicturePaige8(String picturePaige8) {
        this.picturePaige8 = picturePaige8;
    }

    public String getPicturePaige9() {
        return picturePaige9;
    }

    public void setPicturePaige9(String picturePaige9) {
        this.picturePaige9 = picturePaige9;
    }

    public String getPicturePaige10() {
        return picturePaige10;
    }

    public void setPicturePaige10(String picturePaige10) {
        this.picturePaige10 = picturePaige10;
    }

    @Override
    public String toString() {
        return "Paige{" +
                "id=" + id +
                ", nameArticle='" + nameArticle + '\'' +
                ", fullTextArticle='" + fullTextArticle + '\'' +
                ", mainPicturePaige='" + mainPicturePaige + '\'' +
                ", picturePaige1='" + picturePaige1 + '\'' +
                ", picturePaige2='" + picturePaige2 + '\'' +
                ", picturePaige3='" + picturePaige3 + '\'' +
                ", picturePaige4='" + picturePaige4 + '\'' +
                ", picturePaige5='" + picturePaige5 + '\'' +
                ", picturePaige6='" + picturePaige6 + '\'' +
                ", picturePaige7='" + picturePaige7 + '\'' +
                ", picturePaige8='" + picturePaige8 + '\'' +
                ", picturePaige9='" + picturePaige9 + '\'' +
                ", picturePaige10='" + picturePaige10 + '\'' +
                '}';
    }
}
