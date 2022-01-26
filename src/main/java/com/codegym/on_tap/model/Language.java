package com.codegym.on_tap.model;

import lombok.Data;


public class Language {
    private String user;
    private String home;
    private String product;

    public Language(String user, String home, String product) {
        this.user = user;
        this.home = home;
        this.product = product;
    }

    public Language() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
