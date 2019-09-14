package com.spin.bean;


import lombok.Data;

@Data
public class Product {

    private int id ;
    private String name;
    private String path;
    private long createTime;
    private int colorId;
    private int texture;
    private int createUserId;
    private String tianmaoUrl;
}
