package com.cqut.beautiful.dto;

import com.cqut.beautiful.entity.Project;

public class Projects extends Project {

    private String imageurl;

    public Projects() {
    }

    public Projects(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


}
