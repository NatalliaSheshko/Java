package org.example.demo.model;

import java.util.Date;

public class Payment {
    public Date date;
    protected String Id;
    protected boolean paymentOfCredit;
    protected float sum;
    public StatusOfPayment status;
    //Order


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(String id) {
        Id = id;
    }

    public boolean isPaymentOfCredit() {
        return paymentOfCredit;
    }

    public void setPaymentOfCredit(boolean paymentOfCredit) {
        this.paymentOfCredit = paymentOfCredit;
    }

    public float getSum() {
        return sum;
    }

    public StatusOfPayment getStatus() {
        return status;
    }

    public void setStatus(StatusOfPayment status) {
        this.status = status;
    }

    public Payment(Date date, String id, boolean paymentOfCredit, float sum, StatusOfPayment status) {
        this.date = date;
        Id = id;
        this.paymentOfCredit = paymentOfCredit;
        this.sum = sum;
        this.status = status;
    }

    public Payment() {
    }

    protected String getId(){//возвращает Id платежа
        return Id;
    };
    protected void setSum(float sum) {//устанавливает сумму
        this.sum = sum;
    };
}
