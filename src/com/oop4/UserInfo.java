package com.oop4;

public class UserInfo {

    String userId;
    String userPassword;
    String username;
    String userAddress;
    String phoneNumber;

    // tip - 객체 생성될 때 가장 먼저 실행되는 부분은 생성자이다.
    public UserInfo(String userId) {
        this.userId = userId;
    }

    public UserInfo(String Id, String userPassword) {
        this.userId = Id;
        this.userPassword = userPassword;
    }

    public UserInfo(String Id, String userPassword, String username) {
        this.userId = Id;
        this.userPassword = userPassword;
        this.username = username;
    }

    public UserInfo(String userId, String userPassword, String username, String userAddress) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.username = username;
        this.userAddress = userAddress;
    }

    public UserInfo(String userId, String userPassword, String username, String userAddress, String phoneNumber) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.username = username;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
    }

    public void Info() {
        System.out.println("---유저정보---");

    }
}
