package com.pbo.tubes.model.user;

import com.pbo.tubes.model.Level;

public class User {

    private String name, email, password;
    Level level;

    public User(String name, String email, String password, Level level) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }
}
