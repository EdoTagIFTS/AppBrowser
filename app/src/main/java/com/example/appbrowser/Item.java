package com.example.appbrowser;

public class Item {
    private int img;
    private String name;

    public Item(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
