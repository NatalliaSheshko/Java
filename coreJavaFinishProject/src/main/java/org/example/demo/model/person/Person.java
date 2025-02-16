package org.example.demo.model.person;

public class Person extends User {
    protected String phone;
    protected typeOfPerson type;

    public Person(String login, String password, String phone){
        super();//конструктор
        this.phone = phone;
        type=typeOfPerson.CLIENT;
    }

    protected void get(){};
    protected void set(){};

}
