package com.kmd.myapp2.model;

public class User {
    private String description;
    private int imgId;
    private String name;

    public User(String description, int imgId, String name) {
        this.description = description;
        this.imgId = imgId;
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
