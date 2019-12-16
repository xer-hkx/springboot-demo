package com.resource.share.entity;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private Integer isAdmin;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
