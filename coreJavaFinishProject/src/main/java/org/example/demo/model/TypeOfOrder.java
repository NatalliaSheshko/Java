package org.example.demo.model;

public enum TypeOfOrder {
    WITHDELAY("С отсрочкой"),
    WITHOUTDELAY("Без отсрочки");
    private String type;
    TypeOfOrder(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
