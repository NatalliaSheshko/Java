package org.example.demo.model.person;

public class Client extends Person {
    protected String address;
    //protected Agreement;
    protected String email;
    //protected Order;
    protected String payment;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Client(String login, String password, String phone) {
        super(login, password, phone);
    }


    protected void cancelAgreement(){};//отменить соглашение
    protected void confirmAgreement(){};//подтвердить соглашение
    protected void makeOrder(){};//создать заказ
    protected void confirmPayment(){};//подтвердить оплату

}
