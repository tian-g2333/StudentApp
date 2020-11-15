package com.android.hys.studentapp.utitls;

public class SecondHandGoods {
    private int picture;//商品图片
    private String price;//商品价格
    private String name;//商品名称

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public SecondHandGoods(int picture, String price, String name) {
        this.picture = picture;
        this.price = price;
        this.name = name;
    }
}
