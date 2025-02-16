package org.example.demo.model;

public enum StatusOfOrder {
    NEW("Новый"),
    FINISHED("Закрыт"),
    CANCELED("Отменен");
    private String status;
    StatusOfOrder(String status){
        this.status = status;
    }
    public String getStatus(){

        return status;
    }
}
