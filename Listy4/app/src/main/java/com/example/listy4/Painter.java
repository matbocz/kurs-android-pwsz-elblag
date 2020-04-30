package com.example.listy4;

public class Painter {
    private String name;
    private int picture;
    boolean toDelete;

    public Painter(String name, int picture, boolean toDelete) {
        this.name = name;
        this.picture = picture;
        this.toDelete = toDelete;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }
}
