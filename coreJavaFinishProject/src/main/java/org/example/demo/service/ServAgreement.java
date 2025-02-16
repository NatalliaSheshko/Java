package org.example.demo.service;

import java.util.Date;

public class ServAgreement {

    protected void makeAgreement(){};//создать соглашение

    public void infoAgreement(Date date, int number){//вывод информации о соглашении
        System.out.printf("Соглашение № %d%n от %tD", number, date);
    }

    public void printAgreement(Date date, int number, float sum ){}//печать соглашения
}
