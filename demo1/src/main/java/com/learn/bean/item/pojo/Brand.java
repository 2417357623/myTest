package com.learn.bean.item.pojo;

public class Brand {
    private Integer id;
    private String brandName;
    private Integer ordered;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }


    public Brand() {
    }

    public Brand(Integer id, String brandName, Integer ordered) {
        this.id = id;
        this.brandName = brandName;
        this.ordered = ordered;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", ordered=" + ordered +
                '}';
    }
}
