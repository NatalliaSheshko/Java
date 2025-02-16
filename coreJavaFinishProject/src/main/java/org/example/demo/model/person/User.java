package org.example.demo.model.person;

public abstract class User {
    protected String login;
    protected String password;
    protected String Id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public User(String login, String password){//конструктор
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public void setValues(String login, String password){//установить логин и пароль
        this.login = login;
        this.password = password;
    }
}
