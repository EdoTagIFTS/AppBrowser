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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return img == item.img && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img, name);
    }
}
