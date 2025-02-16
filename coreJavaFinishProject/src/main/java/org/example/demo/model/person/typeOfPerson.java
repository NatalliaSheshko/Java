package org.example.demo.model.person;

public enum typeOfPerson {
    CLIENT("Клиент"), EMPLOYEE("Работник");
    private String type;
    typeOfPerson(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
