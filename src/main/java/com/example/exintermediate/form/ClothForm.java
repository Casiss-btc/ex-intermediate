package com.example.exintermediate.form;

public class ClothForm {
    private Integer gender;
    private String color;
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "ClothForm [gender=" + gender + ", color=" + color + "]";
    }
    

}
