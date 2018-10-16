package com.nixsolutions.service.impl;

import java.util.Date;

public class User {

    public User(String login, String password, String email, String firstName,
            String lastName) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    private Role role;
    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthday;

    public User() {

    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date berthday) {
        this.birthday = birthday;
    }

    @Override public String toString() {
        return "User{" + "login='" + login + '\'' + ", password='" + password
                + '\'' + ", email='" + email + '\'' + ", firstName='"
                + firstName + '\'' + ", lastName='" + lastName + '\'' + '}'+ "\n";
    }
}
