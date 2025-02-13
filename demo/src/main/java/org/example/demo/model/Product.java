package org.example.demo.model;

public class Product {
    protected String Id;
    protected float price;
    protected String name;
    protected enum typeOfProduct{CAR, DEVICE};

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String id, float price, String name) {
        Id = id;
        this.price = price;
        this.name = name;
    }

    public Product() {
    }

    protected void getProduct (){};
    protected void setProduct (){};

    protected void sortProduct(String Id, float price, String name){};//сортировать продукты

    public void foundProduct(String Id, float price, String name){};//найти продукт

    protected void countProduct(String Id){};//посчитать продукты

}
