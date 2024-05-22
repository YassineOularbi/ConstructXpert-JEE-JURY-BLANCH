package org.dto;

import org.model.User;

public class UserDTO {
    private String name;
    private String userName;
    private String userEmail;
    private String picture;

    public UserDTO(User user) {
        this.name = user.getName();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.picture = user.getPicture();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
