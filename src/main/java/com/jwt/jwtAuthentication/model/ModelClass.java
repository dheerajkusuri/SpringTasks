package com.jwt.jwtAuthentication.model;

public class ModelClass {
    String username;
    String password;

    public ModelClass() {
    }

    public ModelClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
