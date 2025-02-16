package org.example.demo.model;

import java.util.Date;

public class Order {
    public Date date;
    public String Id;
    public StatusOfOrder status;
    public float sum;
    public TypeOfOrder type;
    //public Agreement;
    //public Product;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public StatusOfOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOfOrder status) {
        this.status = status;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public TypeOfOrder getType() {
        return type;
    }

    public void setType(TypeOfOrder type) {
        this.type = type;
    }

    public Order(Date date, String Id, StatusOfOrder status, float sum, TypeOfOrder type){//конструктор
        this.date = date;
        this.Id = Id;
        status = StatusOfOrder.NEW;
        this.sum = sum;
        type = TypeOfOrder.WITHOUTDELAY;
        //как присвоить значения из объектов (Payment, Product)?
    }

    public Order() {
    }


}
