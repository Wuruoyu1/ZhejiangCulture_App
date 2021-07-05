package com.android.history.bean;

import java.io.Serializable;

public class Info implements Serializable {
    private String name;//名称
    private Integer image;//图片地址
    private String info;//描述


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Info(String name, Integer image, String info) {
        this.name = name;
        this.image = image;
        this.info = info;
    }
}
