package org.example.demo.model;

import javafx.beans.property.*;

public class Avto {
    //Property позволяет получать автоматические уведомления при любых изменениях переменных
    private final StringProperty name;
    private final IntegerProperty price;
    private final IntegerProperty enginePower;
    private final FloatProperty engineCapacity;
    private final FloatProperty acceleration;
    private final FloatProperty fuelConsumption;

    //Конструктор по умолчанию:
    public Avto() {
        this(null);
    }

    //Конструктор с некоторыми начальными данными:
    public Avto(String name) {
        this.name = new SimpleStringProperty(name);
        //Начальные данные:
        this.price = new SimpleIntegerProperty(80000);
        this.enginePower = new SimpleIntegerProperty(147);
        this.engineCapacity = new SimpleFloatProperty(1.5F);
        this.acceleration = new SimpleFloatProperty(8.1F);
        this.fuelConsumption = new SimpleFloatProperty(6.1F);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public int getEnginePower() {
        return enginePower.get();
    }

    public IntegerProperty enginePowerProperty() {
        return enginePower;
    }

    public float getEngineCapacity() {
        return engineCapacity.get();
    }

    public FloatProperty engineCapacityProperty() {
        return engineCapacity;
    }

    public float getAcceleration() {
        return acceleration.get();
    }

    public FloatProperty accelerationProperty() {
        return acceleration;
    }

    public float getFuelConsumption() {
        return fuelConsumption.get();
    }

    public FloatProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrice(Integer price) {
        this.price.set(price);
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower.set(enginePower);
    }

    public void setEngineCapacity(Float engineCapacity) {
        this.engineCapacity.set(engineCapacity);
    }

    public void setAcceleration(Float acceleration) {
        this.acceleration.set(acceleration);
    }

    public void setFuelConsumption(Float fuelConsumption) {
        this.fuelConsumption.set(fuelConsumption);
    }
}

