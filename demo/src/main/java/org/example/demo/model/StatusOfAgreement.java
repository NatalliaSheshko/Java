package org.example.demo.model;

public enum StatusOfAgreement {
    NEW("Новый"),
    CONFIRMED("Согласован"),
    CANCELED("Отменен");
    private String status;
    StatusOfAgreement(String status){
        this.status =status;
    }
    public String getStatus(){
        return status;
    }
}
