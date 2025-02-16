package org.example.demo.model;

public enum typeOfProduct {
    CAR("Автомобиль"),
    DEVICE("Другое");
    private String type;
    typeOfProduct(String type){
        this.type =type;
    }
    public String getType(){
        return type;
    }
}
