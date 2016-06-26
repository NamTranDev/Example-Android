package com.example.namtran.allcountrys.Database;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Country {
    public static final String TABLE = "Mcountrys";
    public static final String ID = "_id";
    public static final String NAME_VI = "nameVi";
    public static final String NAME_EN = "nameEn";
    public static final String IMAGE = "image";
    public static final String LANGUAGE = "language";
    public static final String CAPTION = "caption";
    public static final String POPULATION = "population";
    public static final String ACREAGE = "acreage";
    int id;
    String nameVi;
    String nameEn;
    String Image;
    String language;
    String caption;
    long population;
    double acreage;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public Country() {
        this.id = id;
        this.nameVi = nameVi;
        this.nameEn = nameEn;
        this.Image = Image;
        this.language = language;
        this.caption = caption;
        this.population = population;
        this.acreage = acreage;
    }


}
