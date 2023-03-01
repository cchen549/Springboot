package com.chen.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

    public int getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return username;
    }

    public User setName(String username) {
        this.username = username;
        return this;
    }

    public String getPassword(){
        return password;
    }

    public User setPassword(String password){
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

}
