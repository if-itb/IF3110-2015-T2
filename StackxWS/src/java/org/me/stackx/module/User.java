/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackx.module;

/**
 *
 * @author natanelia
 */
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String createDate;

    public User(int userId, String name, String email, String password, String createDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    
}
