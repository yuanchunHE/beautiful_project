package com.cqut.beautiful.dto;

import com.cqut.beautiful.entity.Order;

public class Orders extends Order {
    private String techname;

    public Orders(String techname) {
        this.techname = techname;
    }

    public Orders() {
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }
}
