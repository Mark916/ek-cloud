package com.ouke.cloud.dto;


public class Brand {
    Long id;
    String brandCode;
    String brandDesc;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Long getId() {
        return id;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public String getBrandDesc() {
        return brandDesc;
    }
}
