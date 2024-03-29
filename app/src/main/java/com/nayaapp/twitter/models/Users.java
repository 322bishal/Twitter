package com.nayaapp.twitter.models;

public class Users {
    String email;
    String password;
    String username;
    String image;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
