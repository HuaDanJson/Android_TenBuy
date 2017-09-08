package com.example.administrator.tenbuy.bean;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ClasslyBean {
    private String name;
    private int image;

    public ClasslyBean(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
