package org.example.demo.model.person;

public class Employee extends Person {
    protected String agreement;
    protected int department;
    protected int grade;
    protected float salary;

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    Employee(String login, String password, String phone) {
        super(login, password, phone);
    }

    public Employee(String login, String password, String phone, String agreement, int department, int grade, float salary) {
        super(login, password, phone);
        this.agreement = agreement;
        this.department = department;
        this.grade = grade;
        this.salary = salary;
    }

}
