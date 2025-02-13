package org.example.demo.model;

import java.util.Date;

public class Agreement {
    protected Date date;
    protected String Id;
    protected int number;
    protected String payment;
    protected StatusOfAgreement status;
    protected float sum;

    protected void setDate(Date date){this.date = date;};
    protected void setId(String Id){this.Id = Id;};
    protected void setNumber(int number){this.number = number;};

    protected Date getDate(){return date;};
    protected String getId(){return Id;};
    protected int getNumber(){return number;};




}
