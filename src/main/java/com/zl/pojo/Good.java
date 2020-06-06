package com.zl.pojo;

public class Good {
    private String img;
    private String price;
    private String name;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    @Override
    public String toString() {
        return "Good{" +
                "img='" + img + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
