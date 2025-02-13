package org.example.demo.model;

public enum StatusOfPayment {
    NEW("Новый"),
    CONFIRMED("Согласован"),
    CANCELED("Отменен");
    private String status;
    StatusOfPayment(String status){
        this.status =status;
    }
    public String getStatus(){
        return status;
    }
}
